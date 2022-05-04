package main

import (
	"fmt"
	"strings"
	"time"
)

type LogProcess struct {
	rc          chan string // 读取chan
	wc          chan string // 写入chan
	path        string      // 文件路径
	influxDBDsn string      // influxDB路径
}

func (l *LogProcess) ReadFromFile() {
	// 日志读取模块
	m := "message"
	l.rc <- m
}

func (l *LogProcess) Process() {
	// 日志解析模块
	m := <-l.rc
	s := strings.ToUpper(m)
	l.wc <- s
}

func (l *LogProcess) WriteToInfluxDB() {
	// 日志写入模块
	fmt.Println(<-l.wc)
}

func main() {
	l := &LogProcess{
		rc:          make(chan string),
		wc:          make(chan string),
		path:        "/tmp/log",
		influxDBDsn: "userName&password",
	}
	// 异步执行
	go l.ReadFromFile()
	go l.Process()
	go l.WriteToInfluxDB()
	time.Sleep(1 * time.Second)
}
