package com.example.controller;
import com.example.beans.Resume;
import com.example.service.ResumeIntroduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
@CrossOrigin("http://localhost:8080")
public class MyResumeIntroduceController {
    @Autowired
    private ResumeIntroduceService myintroduce;

    @RequestMapping("/add_introduce")
    public String insert_introduce(Resume resume) {
        myintroduce.updateIntroduce(resume);
        return "更新成功";
    }

    @RequestMapping("/introduce")
    public String get_introduce(int id) {
        return myintroduce.getResume(id).toString();
    }
}

