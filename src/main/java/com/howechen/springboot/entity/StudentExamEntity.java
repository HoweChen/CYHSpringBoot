package com.howechen.springboot.entity;

import com.howechen.springboot.dto.exam.StudentExamDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.redis.core.RedisHash;


/**
 * @author howechen
 */
@RedisHash("StudentExam")
@EqualsAndHashCode(callSuper = true)
@Data
public class StudentExamEntity extends BaseEntity<StudentExamDto, StudentExamEntity> {

  private final static String ID_PREFIX = "EXAM-";

  private Integer id;
  private String examId;
  private String studentId;
  private Float grade;

  @Override
  public StudentExamEntity toDao(StudentExamDto dto) {
    this.examId =
        dto.getExamId().contains(ID_PREFIX) ? dto.getExamId() : ID_PREFIX.concat(dto.getExamId());
    this.studentId = dto.getStudentId();
    this.grade = Float.parseFloat(dto.getGrade());
    return this;
  }
}
