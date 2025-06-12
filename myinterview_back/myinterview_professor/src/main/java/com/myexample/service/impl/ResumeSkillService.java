package com.myexample.service.impl;

import com.myexample.beans.Resume;
import com.myexample.mapper.ResumeSkillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeSkillService implements com.myexample.service.ResumeSkillService {
    @Autowired
    private ResumeSkillMapper myskill;

    @Override
    public void updateSkill(Resume resume){
        myskill.updateSkill(resume);
    }

}
