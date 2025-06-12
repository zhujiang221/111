package com.example.mapper;

import com.example.beans.Resume;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ResumeIntroduceMapper {
    @Update("insert into resume(username,sex,age,school,tel,grade,introduce"+
    "values(#{username},#{sex},#{age},#{school},#{tel},#{grade},#{introduce}")
    public void InsertIntroduce(Resume resume);
    @Select("/select * from where id =#{id}")
    public Resume getResume(int id);

}
