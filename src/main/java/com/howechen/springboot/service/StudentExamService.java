package com.howechen.springboot.service;

import com.howechen.springboot.entity.StudentExamEntity;

public interface StudentExamService{


    int deleteByPrimaryKey(Integer id);

    int insert(StudentExamEntity record);

    int insertSelective(StudentExamEntity record);

    StudentExamEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudentExamEntity record);

    int updateByPrimaryKey(StudentExamEntity record);

}
