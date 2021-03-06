package com.howechen.springboot.dto.exam;

import com.howechen.springboot.dto.BaseRequestDto;
import com.howechen.springboot.entity.StudentExamEntity;
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
public class StudentExamDto extends BaseRequestDto<StudentExamDto, StudentExamEntity> {

  private String examId;
  private String studentId;
  private String grade;

  @Override
  public StudentExamDto fromDao(StudentExamEntity dao) {
    this.examId = dao.getExamId();
    this.studentId = dao.getStudentId();
    this.grade = dao.getGrade().toString();
    return this;
  }
}
