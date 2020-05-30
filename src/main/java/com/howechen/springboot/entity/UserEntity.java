package com.howechen.springboot.entity;

import com.howechen.springboot.dto.UserDto;
import com.howechen.springboot.utils.PasswordUtils;
import java.util.Base64;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author howechen
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity<UserDto, UserEntity> {

  @Id
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid")
  @Column(name = "id")
  private String id;

  @Column(name = "username")
  private String username;

  @Column(name = "password")
  private String password;

  @Column(name = "salt")
  private String salt;

  @PrePersist
  public void encryption() {
    final byte[] salt = PasswordUtils.generateSalt();
    this.salt = Base64.getEncoder().encodeToString(salt);
    password = PasswordUtils.generatePassword(salt, password);
  }

  @Override
  public UserEntity toDao(UserDto dto) {
    username = dto.getUsername();
    return this;
  }
}
