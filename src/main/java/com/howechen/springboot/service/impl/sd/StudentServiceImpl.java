package com.howechen.springboot.service.impl.sd;

import com.howechen.springboot.dao.StudentRepo;
import com.howechen.springboot.dao.mybatis.StudentDao;
import com.howechen.springboot.dto.StudentDto;
import com.howechen.springboot.entity.StudentEntity;
import com.howechen.springboot.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author howechen
 */
@Service(value = "service.sd.student")
@Slf4j
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class StudentServiceImpl implements StudentService {

  private final StudentRepo studentRepo;
  private final StudentDao studentDao;

  @Override
  public StudentDto create(StudentDto studentDto) {

    StudentEntity entity = new StudentEntity().toDao(studentDto);
    studentDao.insert(entity);
    StudentDto result = new StudentDto();
    return result.fromDao(entity);
  }

  @Override
  public StudentDto queryStudent(String studentId) {
    final StudentEntity foundStudent = studentDao.selectAllByStudentId(studentId);
    return new StudentDto().fromDao(foundStudent);
  }
}
