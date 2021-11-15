package com.fan.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
//名字不可为空
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Guest {
    @NotBlank(message = "{guest.name.notblank}")
    private String name;
    @NotBlank
    private String password;
}
