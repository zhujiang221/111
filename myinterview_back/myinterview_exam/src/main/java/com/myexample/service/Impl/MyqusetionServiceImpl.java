package com.myexample.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.myexample.beans.MyQuestion;
import com.myexample.beans.MyResult;
import com.myexample.mapper.MyQuestiopnMapper;
import com.myexample.service.MyQusetionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MyqusetionServiceImpl implements MyQusetionService {

    @Autowired
    private MyQuestiopnMapper myQuestiopnMapper;

    @Override
    public void getInsert(MyQuestion myQuestion) {

        myQuestiopnMapper.getInsert(myQuestion);
    }


//    @Override
//    public List<MyQuestion> getQuestion(int page){
//        PageHelper.startPage(page,10);
//       List<MyQuestion> muq=myQuestiopnMapper.getQuestion();
//       return muq;
//    }
//    @Override
    public MyResult getQuestion(int page){
        Page<Object> mypage = PageHelper.startPage(page, 5);
        List<MyQuestion> muq = myQuestiopnMapper.getQuestion();

        MyResult myResult = new MyResult();
        myResult.setMyQuestions(muq);
        myResult.setPage(page);               // 当前页码
        myResult.setTotal(mypage.getTotal()); // 总记录数
        myResult.setPages(mypage.getPages()); // 总页数

        return myResult;
    }
//    @Override
//    public MyResult getQuestion(int page){
//        Page mypage= PageHelper.startPage(page,10);
//        List<MyQuestion> muq=myQuestiopnMapper.getQuestion();
//        MyResult myResult=new MyResult();
//        myResult.setPage(mypage.getPages());
//        myResult.setTotal(mypage.getTotal());
//        myResult.setMyQuestions(muq);
//        return muq;
//    }
}
