package com.fan.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Function implements Serializable {
    private static final long serialVersionUID = -2316343654564847123L;
    private Long functionId;
    private String name;
    private String describe;
    private Integer isButton;
    private Long parentId;
    private String link;
    private Integer deleteFlag;
    private Timestamp createTime;
    private String yl1;
}
