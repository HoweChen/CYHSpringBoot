package com.howechen.springboot.dao;

import com.howechen.springboot.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author howechen
 */
@Repository
public interface StudentRepo extends CrudRepository<StudentEntity, String> {

}
