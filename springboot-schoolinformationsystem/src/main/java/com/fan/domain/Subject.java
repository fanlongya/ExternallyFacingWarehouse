package com.fan.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject implements Serializable {
    private static final long serialVersionUID = -8188885473419326270L;
    private Long subjectId;
    private String name;
    private String describe1;
    private Integer deleteFlag;
    private Timestamp createTime;
    private String yl1;
}
