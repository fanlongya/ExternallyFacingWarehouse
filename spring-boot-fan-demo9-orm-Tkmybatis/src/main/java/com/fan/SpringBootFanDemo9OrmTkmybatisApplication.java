package com.fan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.fan.mapper")
public class SpringBootFanDemo9OrmTkmybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootFanDemo9OrmTkmybatisApplication.class, args);
    }

}
