package com.howechen.springboot.service.impl;

import com.howechen.springboot.entity.StudentExamEntity;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.howechen.springboot.dao.mybatis.StudentExamDao;
import com.howechen.springboot.service.StudentExamService;
@Service
public class StudentExamServiceImpl implements StudentExamService{

    @Resource
    private StudentExamDao studentExamDao;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return studentExamDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(StudentExamEntity record) {
        return studentExamDao.insert(record);
    }

    @Override
    public int insertSelective(StudentExamEntity record) {
        return studentExamDao.insertSelective(record);
    }

    @Override
    public StudentExamEntity selectByPrimaryKey(Integer id) {
        return studentExamDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(StudentExamEntity record) {
        return studentExamDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(StudentExamEntity record) {
        return studentExamDao.updateByPrimaryKey(record);
    }

}
