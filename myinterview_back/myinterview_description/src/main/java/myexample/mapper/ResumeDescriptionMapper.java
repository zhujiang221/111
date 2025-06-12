package myexample.mapper;

import myexample.beans.Resume;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ResumeDescriptionMapper {
    @Update("update resume set project_one=#{project_onr}, " +
            "project_two=#{project_two},project_three=#{project_three} where id=#{id}")
    public void updateDescription(Resume resume);
}
