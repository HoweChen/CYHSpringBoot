package com.howechen.springboot.controller;

import com.howechen.springboot.dto.StudentDto;
import com.howechen.springboot.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/student")
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class StudentController {

  private final StudentService studentService;

  @PostMapping(path = "/create")
  @ResponseBody
  public String create(@RequestBody StudentDto studentDto) {
    studentService.create(studentDto);
    return "12345";
  }

  @GetMapping(path = "/query")
  @ResponseBody
  public StudentDto query(@RequestParam(value = "id") String id) {
    return studentService.queryById(id);
  }
}
