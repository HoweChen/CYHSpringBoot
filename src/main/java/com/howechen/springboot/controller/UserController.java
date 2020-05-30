package com.howechen.springboot.controller;

import com.howechen.springboot.dto.UserDto;
import com.howechen.springboot.service.UserService;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author howechen
 */
@RequestMapping(path = "/user")
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class UserController  {

  private final UserService userService;

  @PostMapping(path = "/create")
  @ResponseBody
  public String create(@RequestBody @Valid UserDto userDto) {
    userService.createUser(userDto);
    return "OK";
  }

  @GetMapping(path = "/query")
  @ResponseBody
  public UserDto query(@RequestParam(value = "username") String username) {
    return userService.queryUser(username);
  }

  @PostMapping(path = "/verify")
  @ResponseBody
  public boolean query(@RequestBody UserDto userDto) {
    return userService.verify(userDto);
  }
}
