package com.pintapartido.backend.shared.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends GenericException{

  private static final String MESSAGE = "NOT_FOUND_RESOURCE";
  public NotFoundException(String detail){
    super(HttpStatus.NOT_FOUND.value(), MESSAGE, detail, HttpStatus.NOT_FOUND);
  }
}
