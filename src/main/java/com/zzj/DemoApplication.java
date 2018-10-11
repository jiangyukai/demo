package com.zzj;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@MapperScan("com.zzj.mapper")//将项目中对应的mapper类的路径加进来就可以了,这个对应了项目中mapper（dao）所对应的包路径
public class DemoApplication {

    protected static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);


    public static void main(String[] args) {
        logger.info("springboot启动***********************开始");
        SpringApplication.run(DemoApplication.class, args);
        logger.info("springboot启动结束***********************");
    }
}
