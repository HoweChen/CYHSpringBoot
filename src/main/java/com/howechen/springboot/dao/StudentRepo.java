package com.howechen.springboot.dao;

import com.howechen.springboot.entity.StudentEntity;
import java.util.Optional;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author howechen
 */
@Repository
public interface StudentRepo extends CrudRepository<StudentEntity, String> {

  Optional<StudentEntity> findAllByStudentId(String studentId);

}
