package com.bat.yalong.count;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.bat.yalong")
@MapperScan(basePackages = "com.bat.yalong.count.mapper")
public class YalongCountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(YalongCountServiceApplication.class, args);
    }
}
