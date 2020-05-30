package com.howechen.springboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.howechen.springboot.entity.UserEntity;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author howechen
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class UserDto extends BaseRequestDto<UserDto, UserEntity> {

  @NotEmpty
  private String username;
  @NotEmpty
  @JsonProperty(access = Access.WRITE_ONLY)
  private String password;

  public UserDto(String username) {
    this.username = username;
  }

  @Override
  public UserDto fromDao(UserEntity dao) {
    username = dao.getUsername();
    password = dao.getPassword();
    return this;
  }
}
