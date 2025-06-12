package com.myexample.beans;


import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyResult {
    private List<MyQuestion> myQuestions;
    private int page;
    private long total;
    private int pages;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
