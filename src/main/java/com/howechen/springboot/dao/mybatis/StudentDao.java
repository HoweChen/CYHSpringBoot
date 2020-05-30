package com.howechen.springboot.dao.mybatis;

import com.howechen.springboot.entity.StudentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.springframework.stereotype.Repository;

/**
 * @author howechen
 */
@Repository
public interface StudentDao {

  void insert(StudentEntity studentEntity);

  StudentEntity selectAllByStudentId(String studentId);
}
