package com.pintapartido.backend.shared.exceptions.category;

import com.pintapartido.backend.shared.exceptions.GenericException;
import org.springframework.http.HttpStatus;

public class ConflictException extends GenericException {
  private static final String MESSAGE ="CONFLICT";
  public ConflictException(String detail){
    super(409,
        MESSAGE,
        detail,
        HttpStatus.CONFLICT);
  }

}
