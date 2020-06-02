package com.howechen.springboot.service.impl.sd;

import com.howechen.springboot.config.ServerException;
import com.howechen.springboot.dao.StudentRepo;
import com.howechen.springboot.dao.mybatis.StudentDao;
import com.howechen.springboot.dto.StudentDto;
import com.howechen.springboot.entity.StudentEntity;
import com.howechen.springboot.service.StudentService;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author howechen
 */
@Service(value = "service.sd.student")
@Slf4j
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class StudentServiceImpl implements StudentService {

  private final StudentRepo studentRepo;

  @Override
  @CachePut(value = "studentCache", key = "#studentDto")
  public StudentDto create(StudentDto studentDto) {
    StudentDto result = new StudentDto();
    StudentEntity entity = new StudentEntity().toDao(studentDto);
    final StudentEntity savedEntity = studentRepo.save(entity);
    return result.fromDao(savedEntity);
  }

  @Override
  @Cacheable(value = "studentCache", key = "#studentId")
  public StudentDto queryStudent(String studentId) {
    StudentDto result = new StudentDto();
    final Optional<StudentEntity> byStudentId = studentRepo.findAllByStudentId(studentId);
    byStudentId.ifPresentOrElse(result::fromDao, () -> {
      throw new ServerException("Cannot find student by given StudentId");
    });
    return result;
  }
}
