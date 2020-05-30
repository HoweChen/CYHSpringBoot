package com.howechen.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

/**
 * @author howechen
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponseDto<T> {

  private static final String OK = "0";
  private static final String ERROR = "1";
  private static final String OK_MSG = "OK";
  private static final String ERROR_MSG = "ERROR";

  private String code = OK;
  private String msg = OK_MSG;
  private T result;


  public BaseResponseDto(T result) {
    this.result = result;
  }

  public static BaseResponseDto<?> error(String msg) {
    return new BaseResponseDto<>(ERROR, StringUtils.isEmpty(msg) ? ERROR_MSG : msg, null);
  }

  public static BaseResponseDto<?> okay() {
    return new BaseResponseDto<>(null);
  }

  @SuppressWarnings("unchecked")
  public BaseResponseDto<T> okayWithResult(T result) {
    final BaseResponseDto<T> response = (BaseResponseDto<T>) BaseResponseDto.okay();
    response.setResult(result);
    return response;
  }


}
