package com.bat.yalong.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.bat.yalong")
public class YalongManageWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(YalongManageWebApplication.class, args);
    }
}
