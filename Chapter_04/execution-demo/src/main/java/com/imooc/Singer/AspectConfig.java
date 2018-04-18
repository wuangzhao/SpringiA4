package com.imooc.Singer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class AspectConfig {
    @Bean
    public Tony tony() {
        return new Tony();
    }

    @Bean
    public ManAspect manAspect() {
        return new ManAspect();
    }
}
