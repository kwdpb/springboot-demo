package com.kw;

import com.kw.Interceptor.CommonInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@MapperScan("com.kw.mapper")
@EnableScheduling
public class SpringbootWebApplication {

    private static  final Logger logger= LoggerFactory.getLogger(SpringbootWebApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebApplication.class, args);
    }

    @Autowired
    CommonInterceptor commonInterceptor;



}
