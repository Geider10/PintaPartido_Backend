package com.pintapartido.backend.club.domain.exceptions;

import com.pintapartido.backend.shared.exceptions.GenericException;
import org.springframework.http.HttpStatus;

public class InvalidateStatusException extends GenericException {

  private static final String MESSAGE = "CONFLICT_WITH_THE_RESOURCE";
  private static String detail  = "Club status cannot be updated because the status is invalidate";
  public InvalidateStatusException(){
    super(HttpStatus.CONFLICT.value(), MESSAGE, detail, HttpStatus.CONFLICT);
  }

}
