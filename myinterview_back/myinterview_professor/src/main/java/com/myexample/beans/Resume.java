package com.myexample.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resume {
    private int id;
    private String username;
    private String sex;
    private String school;
    private String tel;
    private String grade;
    private String email;
    private String skill;
    private String project_one;
    private String project_two;
    private String project_three;
    private String education;
    private String introduce;
}
