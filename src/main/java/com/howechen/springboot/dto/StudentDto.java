package com.howechen.springboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.howechen.springboot.entity.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author howechen
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class StudentDto {

  @JsonProperty(access = Access.READ_ONLY)
  private String studentId;
  private String name;
  private String gender;
  private String grade;

  public static StudentDto fromService(StudentEntity studentEntity) {
    StudentDto result = new StudentDto();
    result.setStudentId(studentEntity.getStudentId());
    result.setName(studentEntity.getName());
    result.setGender(studentEntity.getGender());
    result.setGrade(studentEntity.getGrade().toString());

    return result;
  }
}
