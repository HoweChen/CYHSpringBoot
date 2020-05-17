package com.howechen.springboot.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * @author howechen
 */
@Data
@NoArgsConstructor
public class UserDto {

  private String username;
  @JsonProperty(access = Access.WRITE_ONLY)
  private String password;

  public UserDto(String username) {
    this.username = username;
  }
}
