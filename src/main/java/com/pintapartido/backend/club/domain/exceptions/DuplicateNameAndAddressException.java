package com.pintapartido.backend.club.domain.exceptions;

import com.pintapartido.backend.shared.exceptions.GenericException;
import org.springframework.http.HttpStatus;

public class DuplicateNameAndAddressException extends GenericException {

  private static final String MESSAGE = "CONFLICT_WITH_THE_RESOURCE";
  private static String detail  = "Club cannot be saved because the name and address are duplicated";
  public DuplicateNameAndAddressException() {
    super(HttpStatus.CONFLICT.value(),MESSAGE,detail,HttpStatus.CONFLICT);
  }
}
