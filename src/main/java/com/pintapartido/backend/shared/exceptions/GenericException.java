package com.pintapartido.backend.shared.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GenericException extends RuntimeException {

  private Integer code;
  private String detail;
  private HttpStatus httpStatus;

  public GenericException(Integer code, String message, String detail, HttpStatus httpStatus){
    super(message);
    this.code = code;
    this.detail = detail;
    this.httpStatus = httpStatus;
  }
}
