package com.fan.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {
    private static final long serialVersionUID = -4627073795726533978L;
    private Long roleId;
    private String name;
    private String describe1;
    private Integer deleteFlag;
    private Timestamp createTime;
    private String yl1;
}
