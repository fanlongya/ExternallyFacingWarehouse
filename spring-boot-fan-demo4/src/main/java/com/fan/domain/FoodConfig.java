package com.fan.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("food")
@Data
public class FoodConfig {
    private String meat;
    private String rice;
    private String[] seasoning;
}
