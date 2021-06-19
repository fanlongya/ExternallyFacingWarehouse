package com.fan.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties("emp")
@Getter
@Setter
public class EmpConfig {
    private int[] num;
    private String[] str;
}
