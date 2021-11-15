package com.fan.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course implements Serializable {
    private static final long serialVersionUID = -3866455914257802472L;
    private Long courseId;
    private Long subjectId;
    private Long teacherId;
    private String semester;
    private String faculty;
    private Date startTime;
    private Date endTime;
    private Integer deleteFlag;
    private Timestamp createTime;
    private String yl1;
    private User teacher;
    private Subject subject;
}
