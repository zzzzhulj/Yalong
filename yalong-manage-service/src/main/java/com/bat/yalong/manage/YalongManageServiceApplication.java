package com.bat.yalong.manage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "com.bat.yalong.manage.mapper")
@ComponentScan(basePackages = "com.bat.yalong")
public class YalongManageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(YalongManageServiceApplication.class, args);
    }
}
