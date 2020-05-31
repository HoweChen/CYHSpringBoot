package com.howechen.springboot.service.impl.mybatis;

import com.howechen.springboot.config.ServerException;
import com.howechen.springboot.dao.UserRepo;
import com.howechen.springboot.dto.UserDto;
import com.howechen.springboot.entity.UserEntity;
import com.howechen.springboot.service.UserService;
import com.howechen.springboot.utils.PasswordUtils;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author howechen
 */
@Service(value = "service.mybatis.user")
@Slf4j
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class UserServiceImpl implements UserService {

  private final UserRepo userRepo;

  @Override
  public void createUser(UserDto userDto) throws ServerException {

    log.info("Creating user...");

    UserEntity userEntity = new UserEntity();
    userEntity.setUsername(userDto.getUsername());
    userEntity.setPassword(userDto.getPassword());

    try {
      userRepo.save(userEntity);
    } catch (IllegalArgumentException ex) {
      log.error(ex.getMessage());
      throw new ServerException("Error when saving the user");
    }

  }

  @Override
  public UserDto queryUser(String username) throws ServerException {

    log.info("Query user: {}", username);

    final Optional<UserEntity> byUsernameOpt = userRepo.findByUsername(username);
    UserDto result;
    if (byUsernameOpt.isPresent()) {
      result = new UserDto(byUsernameOpt.get().getUsername());
    } else {
      throw new ServerException("Cannot find user");
    }

    return result;
  }


  @Override
  public boolean verify(UserDto userDto) throws ServerException {
    final Optional<UserEntity> byUsernameOpt = userRepo.findByUsername(userDto.getUsername());
    if (byUsernameOpt.isPresent()) {
      final UserEntity foundUser = byUsernameOpt.get();
      return PasswordUtils
          .verityPassword(userDto.getPassword(), foundUser.getSalt(), foundUser.getPassword());
    } else {
      throw new ServerException("Cannot find user");
    }

  }
}
