package com.fan.mapper;

import com.fan.domain.Subject;
import org.apache.ibatis.annotations.Select;

public interface SubjectMapper {
    @Select("select subject_id subjectId,name,describe1,delete_flag deleteFlag,create_time createTime,yl1 from subject where subject_id=#{subjectId} and delete_flag=0")
    Subject selectOne(Long subjectId);
}
