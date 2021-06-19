package com.fan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fan.mapper")
public class OrmMybatisplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrmMybatisplusApplication.class, args);
    }

}
