package com.howechen.springboot.dao.mybatis;

import com.howechen.springboot.entity.StudentExamEntity;

/**
 * @author howechen
 */
public interface StudentExamDao {
    int deleteByPrimaryKey(Integer id);

    int insert(StudentExamEntity record);

    int insertSelective(StudentExamEntity record);

    StudentExamEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudentExamEntity record);

    int updateByPrimaryKey(StudentExamEntity record);
}