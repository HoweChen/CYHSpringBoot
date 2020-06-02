package com.howechen.springboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.howechen.springboot.entity.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author howechen
 */

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto extends BaseRequestDto<StudentDto, StudentEntity> {

  @JsonProperty(access = Access.READ_ONLY)
  private String studentId;
  private String name;
  private String gender;
  private String registerDate;

  @Override
  public StudentDto fromDao(StudentEntity dao) {
    this.studentId = dao.getStudentId();
    this.name = dao.getName();
    this.gender = dao.getGender();

    if (dao.getRegisterDate() != null) {
      this.registerDate = dao.getRegisterDate().toString();
    }

    return this;
  }
}
