package com.howechen.springboot.dao;

import com.howechen.springboot.entity.UserEntity;
import java.util.Optional;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.repository.CrudRepository;

@RedisHash(value = "user")
public interface UserRepo extends CrudRepository<UserEntity, String> {

  Optional<UserEntity> findByUsername(String username);
}
