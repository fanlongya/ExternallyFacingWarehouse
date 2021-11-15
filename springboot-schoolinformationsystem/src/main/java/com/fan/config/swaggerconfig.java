package com.fan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class swaggerconfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.fan.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }
    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("学校信息管理系统")
                .description("这是一个学校的信息管理系统，为学校的日常运作提供便捷的帮助，实现学校管理的信息化，使学校的管理更便捷。")
                .version("1.0.1")
                .build();
    }
}
