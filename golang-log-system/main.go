package main

import (
	"fmt"
	"strings"
	"time"
)

type LogProcess struct {
	rc     chan string
	wc     chan string
	reader Reader
	writer Writer
}

type Reader interface {
	Read(rc chan string)
}

type Writer interface {
	Write(wc chan string)
}

type ReadFromFile struct {
	filePath string
}

func (r *ReadFromFile) Read(rc chan string) {
	line := "message"
	rc <- line
}

type WriteToInfluxDB struct {
	influxDBDsn string
}

func (w *WriteToInfluxDB) Write(wc chan string) {
	fmt.Println(<-wc)
}

func (l *LogProcess) Process() {
	m := <-l.rc
	s := strings.ToUpper(m)
	l.wc <- s
}

func main() {
	reader := &ReadFromFile{
		filePath: "/tmp/log",
	}
	writer := &WriteToInfluxDB{
		influxDBDsn: "username&password",
	}
	l := &LogProcess{
		rc:     make(chan string),
		wc:     make(chan string),
		reader: reader,
		writer: writer,
	}
	go l.reader.Read(l.rc)
	go l.writer.Write(l.wc)
	go l.Process()
	time.Sleep(1 * time.Second)
}
