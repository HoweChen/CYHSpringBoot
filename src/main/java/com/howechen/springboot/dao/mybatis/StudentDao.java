package com.howechen.springboot.dao.mybatis;

import com.howechen.springboot.dto.student.StudentQueryDto;
import com.howechen.springboot.entity.StudentEntity;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @author howechen
 */
@Repository
public interface StudentDao {

  void insert(StudentEntity studentEntity);

  StudentEntity selectAllByStudentId(String studentId);

  List<StudentEntity> selectByFields(StudentQueryDto studentQueryDto);
}
