package com.howechen.springboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author howechen
 */
@Data
@NoArgsConstructor
public class UserDto {

  @NotEmpty
  private String username;
  @NotEmpty
  @JsonProperty(access = Access.WRITE_ONLY)
  private String password;

  public UserDto(String username) {
    this.username = username;
  }
}
