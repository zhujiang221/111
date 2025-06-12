package com.example.service.impl;

import com.example.beans.Resume;
import com.example.mapper.ResumeIntroduceMapper;
import com.example.service.ResumeIntroduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeIntroduceServiceImpl implements ResumeIntroduceService {
    @Autowired
    private ResumeIntroduceMapper myintroduce;

    @Override
    public void updateIntroduce(Resume resume){
        myintroduce.InsertIntroduce(resume);
    }
    @Override
    public Resume getResume(int id){
        return myintroduce.getResume(id);
    }

}
