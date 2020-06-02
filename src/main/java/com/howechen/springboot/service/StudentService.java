package com.howechen.springboot.service;

import com.howechen.springboot.dto.student.StudentDto;
import com.howechen.springboot.dto.student.StudentQueryDto;
import java.util.List;

public interface StudentService {

  StudentDto create(StudentDto studentDto);

  StudentDto queryStudent(String studentId);

  List<StudentDto> queryStudentByFields(StudentQueryDto studentQueryDto);
}
