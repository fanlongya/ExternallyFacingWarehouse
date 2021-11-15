package com.fan.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = -9161405571997339780L;
    private Long userId;
    private String name;
    private String password;
    private Character sex;
    private Integer age;
    private Date birthday;
    private String college;
    private String faculty;
    private String profession;
    private Long classId;
    private Integer deleteFlag;
    private Timestamp createTime;
    private String yl1;
    private Classed classed;
    private List<Role> roleList;
}
