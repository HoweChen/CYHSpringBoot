package com.howechen.springboot.dao;

import com.howechen.springboot.entity.UserEntity;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, String> {

  Optional<UserEntity> findByUsername(String username);
}
