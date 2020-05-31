package com.howechen.springboot.controller;

import com.howechen.springboot.dto.BaseResponseDto;
import com.howechen.springboot.dto.StudentDto;
import com.howechen.springboot.service.impl.mybatis.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
public class StudentController {

  @Qualifier(value = "service.mybatis.student")
  private final StudentServiceImpl mybatisStudentService;
  @Qualifier(value = "service.sd.student")
  private final com.howechen.springboot.service.impl.sd.StudentServiceImpl sdStudentService;

  @Autowired
  public StudentController(
      StudentServiceImpl mybatisStudentService,
      com.howechen.springboot.service.impl.sd.StudentServiceImpl sdStudentService) {
    this.mybatisStudentService = mybatisStudentService;
    this.sdStudentService = sdStudentService;
  }


  @PostMapping(path = "/mybatis/create")
  @ResponseBody
  public DeferredResult<BaseResponseDto<?>> myBatisCreate(@RequestBody StudentDto studentDto) {
    final StudentDto result = mybatisStudentService.create(studentDto);
    final DeferredResult<BaseResponseDto<?>> response = new DeferredResult<>();
    final BaseResponseDto<StudentDto> responseDto = new BaseResponseDto<StudentDto>()
        .okayWithResult(result);
    response.setResult(responseDto);
    return response;
  }

  @GetMapping(path = "/mybatis/query")
  @ResponseBody
  public DeferredResult<BaseResponseDto<StudentDto>> mybatisQuery(
      @RequestParam(value = "id") String studentId) {
    final DeferredResult<BaseResponseDto<StudentDto>> result = new DeferredResult<>();
    final StudentDto serviceResult = mybatisStudentService.queryStudent(studentId);
    final BaseResponseDto<StudentDto> responseDto = new BaseResponseDto<StudentDto>()
        .okayWithResult(serviceResult);
    result.setResult(responseDto);
    return result;
  }

  @PostMapping(path = "/sd/create")
  @ResponseBody
  public DeferredResult<BaseResponseDto<?>> sdCreate(@RequestBody StudentDto studentDto) {
    final StudentDto result = mybatisStudentService.create(studentDto);
    final DeferredResult<BaseResponseDto<?>> response = new DeferredResult<>();
    final BaseResponseDto<StudentDto> responseDto = new BaseResponseDto<StudentDto>()
        .okayWithResult(result);
    response.setResult(responseDto);
    return response;
  }

  @GetMapping(path = "/sd/query")
  @ResponseBody
  public DeferredResult<BaseResponseDto<StudentDto>> sdQuery(
      @RequestParam(value = "id") String studentId) {
    final DeferredResult<BaseResponseDto<StudentDto>> result = new DeferredResult<>();
    final StudentDto serviceResult = mybatisStudentService.queryStudent(studentId);
    final BaseResponseDto<StudentDto> responseDto = new BaseResponseDto<StudentDto>()
        .okayWithResult(serviceResult);
    result.setResult(responseDto);
    return result;
  }
}
