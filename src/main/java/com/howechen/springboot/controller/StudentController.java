package com.howechen.springboot.controller;

import com.howechen.springboot.dto.BaseResponseDto;
import com.howechen.springboot.dto.StudentDto;
import com.howechen.springboot.service.impl.StudentServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
@RequestMapping(path = "/student")
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class StudentController {

  private final StudentServiceImpl studentService;

  @PostMapping(path = "/create")
  @ResponseBody
  public DeferredResult<BaseResponseDto<?>> create(@RequestBody StudentDto studentDto) {
    final StudentDto result = studentService.create(studentDto);
    final DeferredResult<BaseResponseDto<?>> response = new DeferredResult<>();
    final BaseResponseDto<StudentDto> responseDto = new BaseResponseDto<StudentDto>()
        .okayWithResult(result);
    response.setResult(responseDto);
    return response;
  }

  @GetMapping(path = "/query")
  @ResponseBody
  public DeferredResult<BaseResponseDto<StudentDto>> query(
      @RequestParam(value = "id") String studentId) {
    final DeferredResult<BaseResponseDto<StudentDto>> result = new DeferredResult<>();
    final StudentDto serviceResult = studentService.queryStudent(studentId);
    final BaseResponseDto<StudentDto> responseDto = new BaseResponseDto<StudentDto>()
        .okayWithResult(serviceResult);
    result.setResult(responseDto);
    return result;
  }
}
