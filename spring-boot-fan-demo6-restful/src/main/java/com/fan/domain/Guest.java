package com.fan.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Guest {
    private Long id;
    private String name;
    private String role;
}
