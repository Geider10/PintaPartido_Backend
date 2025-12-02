package com.pintapartido.backend.shared.exceptions.category;

import com.pintapartido.backend.shared.exceptions.GenericException;
import org.springframework.http.HttpStatus;

public class DomainValidationException extends GenericException {
  private static final String MESSAGE = "UNPROCESSABLE_ENTITY";
  public DomainValidationException(String detail){
    super(422,
        MESSAGE,
        detail,
        HttpStatus.UNPROCESSABLE_ENTITY);
  }

}
