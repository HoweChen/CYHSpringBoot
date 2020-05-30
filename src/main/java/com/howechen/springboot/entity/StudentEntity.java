package com.howechen.springboot.entity;

import com.howechen.springboot.dto.StudentDto;
import java.util.UUID;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.data.redis.core.RedisHash;


/**
 * @author howechen
 */
@RedisHash("Student")
@EqualsAndHashCode(callSuper = true)
@Data
public class StudentEntity extends BaseEntity<StudentDto, StudentEntity> {

  private final static String ID_PREFIX = "STUDENT-";

  public enum Gender {
    // male
    MALE,
    // female
    FEMALE
  }

  private Integer id;
  private String studentId;
  private String name;
  private String gender;

  @Override
  public StudentEntity toDao(StudentDto dto) {
    // default gender
    final Gender gender = EnumUtils.getEnumIgnoreCase(Gender.class, dto.getGender());
    String genderString;
    if (gender == null) {
      genderString = Gender.MALE.toString();
    } else {
      genderString = gender.toString();
    }

    this.name = dto.getName();
    this.studentId = ID_PREFIX.concat(UUID.randomUUID().toString());
    this.gender = genderString;
    return this;
  }
}
