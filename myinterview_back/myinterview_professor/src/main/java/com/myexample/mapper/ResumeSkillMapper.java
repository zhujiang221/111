package com.myexample.mapper;

import com.myexample.beans.Resume;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ResumeSkillMapper {
    @Update("update resume set skill=#{skill} where id=#{id}")
    public void updateSkill(Resume resume);
}
