package com.zhonghuasheng.ms;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.io.ClassPathResource;

import java.util.Properties;

@EnableDiscoveryClient
@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class})
public class UserApplication {

    public static void main(String[] args) {
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource("bootstrap.yml"));
        Properties property = yaml.getObject();
        System.setProperty("SERVICE_NAME", property.getProperty("spring.application.name"));
        System.setProperty("FILE_PATH", property.getProperty("logging.file.path"));
        SpringApplication.run(UserApplication.class);
    }
}
