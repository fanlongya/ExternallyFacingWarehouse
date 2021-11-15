package com.fan.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classed implements Serializable {
    private static final long serialVersionUID = -6288786783990390578L;
    private Long classId;
    private String name;
    private Long teacherId;
    private Integer deleteFlag;
    private Timestamp createTime;
    private String yl1;
    private List<Course> courseList;
}
