package com.myexample.service;


import com.myexample.beans.MyQuestion;
import com.myexample.beans.MyResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MyQusetionService {
    public void getInsert(MyQuestion question);
    public MyResult getQuestion(int page);
}
