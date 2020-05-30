package com.howechen.springboot.service;

import com.howechen.springboot.config.ServerException;
import com.howechen.springboot.dao.UserRepo;
import com.howechen.springboot.dto.UserDto;
import com.howechen.springboot.entity.UserEntity;
import com.howechen.springboot.utils.PasswordUtils;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author howechen
 */
public interface UserService {


  void createUser(UserDto userDto);

  UserDto queryUser(String username);

  boolean verify(UserDto userDto);
}
