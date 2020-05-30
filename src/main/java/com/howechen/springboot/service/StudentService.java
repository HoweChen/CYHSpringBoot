package com.howechen.springboot.service;

import com.howechen.springboot.dto.StudentDto;

public interface StudentService {

  StudentDto create(StudentDto studentDto);

  StudentDto queryStudent(String studentId);

}
