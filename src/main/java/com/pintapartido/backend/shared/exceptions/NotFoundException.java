package com.pintapartido.backend.shared.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends GenericException{

  public NotFoundException(String detail){
    super(HttpStatus.NOT_FOUND.value(),
        HttpCodeMessage.CODE404,
        detail,
        HttpStatus.NOT_FOUND);
  }
}
