package com.howechen.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author howechen
 */
@AllArgsConstructor
@Data
public class StudentDto {

  private String id;
  private String name;
  private String gender;
  private String grade;

}
