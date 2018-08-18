package com.bat.yalong.service.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class AopConfig {

    @Pointcut("execution(* com.bat.yalong.*.*(..))")
    public void executeService() {}

}
