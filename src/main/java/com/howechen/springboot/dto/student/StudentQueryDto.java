package com.howechen.springboot.dto.student;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author howechen
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentQueryDto {

  private String studentId;
  private String name;
  private String gender;
  private Date startDate;
  private Date endDate;
}
