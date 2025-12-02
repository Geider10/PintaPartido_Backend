package com.pintapartido.backend.shared.exceptions.category;

import com.pintapartido.backend.shared.exceptions.GenericException;
import org.springframework.http.HttpStatus;

public class NotFoundException extends GenericException {
  private static final String MESSAGE = "NOT_FOUND";
  public NotFoundException(String detail){
    super(404,
        MESSAGE,
        detail,
        HttpStatus.NOT_FOUND);
  }
}
