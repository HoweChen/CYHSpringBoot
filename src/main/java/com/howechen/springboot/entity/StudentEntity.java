package com.howechen.springboot.entity;

import com.howechen.springboot.dto.StudentDto;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.data.redis.core.RedisHash;


/**
 * @author howechen
 */
@RedisHash("Student")
@EqualsAndHashCode(callSuper = true)
@Data
public class StudentEntity extends BaseEntity {

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
  private Integer grade;

  public static StudentEntity fromWeb(StudentDto studentDto) {
    // default gender
    final Gender gender = EnumUtils.getEnumIgnoreCase(Gender.class, studentDto.getGender());
    String genderString;
    if (gender == null) {
      genderString = Gender.MALE.toString();
    } else {
      genderString = gender.toString();
    }

    StudentEntity result = new StudentEntity();
    result.setName(studentDto.getName());
    result.setStudentId(UUID.randomUUID().toString());
    result.setGender(genderString);
    result.setGrade(Integer.parseInt(studentDto.getGrade()));
    return result;
  }

}
