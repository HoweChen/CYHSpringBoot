package com.howechen.springboot.service.impl;

import com.howechen.springboot.config.ServerException;
import com.howechen.springboot.dao.StudentRepo;
import com.howechen.springboot.dao.mybatis.StudentDao;
import com.howechen.springboot.dto.StudentDto;
import com.howechen.springboot.entity.StudentEntity;
import com.howechen.springboot.service.StudentService;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class StudentServiceImpl implements StudentService {

  private final StudentRepo studentRepo;
  private final StudentDao studentDao;

  @Override
  public void create(StudentDto studentDto) {
    StudentEntity entity = StudentEntity.fromWeb(studentDto);
    studentDao.insert(entity);
  }

  @Override
  public StudentDto queryStudent(String studentId) {
    final StudentEntity foundStudent = studentDao.selectAllByStudentId(studentId);
    return StudentDto.fromService(foundStudent);
  }
}
