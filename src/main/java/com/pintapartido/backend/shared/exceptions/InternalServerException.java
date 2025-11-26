package com.pintapartido.backend.shared.exceptions;

import org.springframework.http.HttpStatus;

public class InternalServerException extends GenericException {

  public InternalServerException(String detail) {
    super(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpCodeMessage.CODE500, detail, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
