package com.yuanlrc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 项目入口启动文件
 **/
@SpringBootApplication
public class app {
    public static void main(String[] args){
        SpringApplication.run(app.class,args);
    }
}

