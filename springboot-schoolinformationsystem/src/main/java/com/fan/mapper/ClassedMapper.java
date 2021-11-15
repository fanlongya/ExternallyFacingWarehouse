package com.fan.mapper;

import com.fan.domain.Classed;
import org.apache.ibatis.annotations.*;

import java.util.List;

//@Mapper
public interface ClassedMapper {
    @Insert("insert into classed value(#{classId},#{name},#{teacherId},#{deleteFlag},now(),#{yl1})")
    Integer insert(Classed classed);
    @Select("select class_id classId,name,teacher_id teacherId,delete_flag deleteFlag,create_time createTime,yl1 from classed where teacher_id = #{teacherId} and delete_flag=0")
    List<Classed> selectOfTeacherId(Long teacherId);
    @Select("select class_id classId,name,teacher_id teacherId,delete_flag deleteFlag,create_time createTime,yl1 from classed where class_id = #{classId} and delete_flag=0")
    Classed selectOne(Long classId);
    @Select("select class_id,name,teacher_id,delete_flag,create_time,yl1 from classed")
    @Results(id = "selectAll",value = {
            @Result(property = "classId",column = "class_id",id = true),
            @Result(property = "name",column = "name"),
            @Result(property = "teacherId",column = "teacher_id"),
            @Result(property = "deleteFlag",column = "delete_flag"),
            @Result(property = "createTime",column = "create_time"),
            @Result(property = "yl1",column = "yl1")
    })
    List<Classed> selectAll();
    @Select("select class_id,name,teacher_id,delete_flag,create_time,yl1 from classed where delete_flag=0")
    @ResultMap("selectAll")
    List<Classed> selectAllOfDeleteFlag();
    @Update("update classed set delete_flag=1 where class_id=#{classId}")
    Integer delete(Long classId);
    @Update("update classed set name=#{name},teacher_id=#{teacherId},yl1=#{yl1} where class_id=#{classId}")
    Integer update(Classed classed);
}
