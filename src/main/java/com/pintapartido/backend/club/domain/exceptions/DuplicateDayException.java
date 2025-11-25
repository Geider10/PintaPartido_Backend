package com.pintapartido.backend.club.domain.exceptions;

import com.pintapartido.backend.shared.exceptions.GenericException;
import org.springframework.http.HttpStatus;

public class DuplicateDayException extends GenericException {

  private static String detail = "Schedule cannot be saved because day type is duplicated";
  public DuplicateDayException(){
    super(HttpStatus.CONFLICT.value(),
        "",
        detail,
        HttpStatus.CONFLICT);
  }
}
