package com.pintapartido.backend.club.domain.exceptions;

import com.pintapartido.backend.shared.exceptions.GenericException;
import com.pintapartido.backend.shared.exceptions.HttpCodeMessage;
import org.springframework.http.HttpStatus;

public class DuplicateClubNameAndAddressException extends GenericException {

  private static String detail = "Club cannot be saved because the name and address are duplicated";
  public DuplicateClubNameAndAddressException() {
    super(HttpStatus.CONFLICT.value(),
        HttpCodeMessage.CODE409,
        detail,
        HttpStatus.CONFLICT);
  }
}
