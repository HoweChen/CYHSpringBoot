package com.howechen.springboot.service.impl.mybatis;

import com.howechen.springboot.dao.StudentRepo;
import com.howechen.springboot.dao.mybatis.StudentDao;
import com.howechen.springboot.dto.student.StudentDto;
import com.howechen.springboot.dto.student.StudentQueryDto;
import com.howechen.springboot.entity.StudentEntity;
import com.howechen.springboot.service.StudentService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author howechen
 */
@Service(value = "service.mybatis.student")
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

  @Override
  public List<StudentDto> queryStudentByFields(StudentQueryDto studentQueryDto) {
    List<StudentDto> result = new ArrayList<>();
    final List<StudentEntity> foundStudents = studentDao.selectByFields(studentQueryDto);
    if (foundStudents != null && !foundStudents.isEmpty()) {
      result = foundStudents.stream().map(studentEntity -> {
        StudentDto dto = new StudentDto();
        dto.fromDao(studentEntity);
        return dto;
      }).collect(Collectors.toList());
    }
    return result;
  }
}
