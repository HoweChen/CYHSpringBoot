package com.howechen.springboot.service;

import com.howechen.springboot.config.ServerException;
import com.howechen.springboot.dao.StudentRepo;
import com.howechen.springboot.dto.StudentDto;
import com.howechen.springboot.entity.StudentEntity;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class StudentService {

  private final StudentRepo studentRepo;

  public void create(StudentDto studentDto) {
    StudentEntity student = new StudentEntity();
    student.setId(studentDto.getId());
    student.setGender(Enum.valueOf(StudentEntity.Gender.class, studentDto.getGender()));
    student.setGrade(Integer.parseInt(studentDto.getGrade()));
    student.setName(studentDto.getName());
    log.info("Saving...");
    studentRepo.save(student);
  }


  public StudentDto queryById(String id) {
    final Optional<StudentEntity> byId = studentRepo.findById(id);
    StudentDto result = null;
    if (byId.isPresent()) {
      final StudentEntity studentEntity = byId.get();
      result = new StudentDto(studentEntity.getId(), studentEntity.getName(),
          studentEntity.getGender().toString(), String.valueOf(studentEntity.getGrade()));
    }

    if (result == null) {
      throw new ServerException("Cannot find by givenId");
    }

    return result;
  }
}
