package com.howechen.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;


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

  private String id;
  private String name;
  private Gender gender;
  private int grade;

}
