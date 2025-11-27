package com.pintapartido.backend.club.domain.exceptions;

import com.pintapartido.backend.shared.exceptions.GenericException;
import com.pintapartido.backend.shared.exceptions.HttpCodeMessage;
import org.springframework.http.HttpStatus;

public class DuplicateCategoryNameException extends GenericException {

  private static String detail = "Category cannot be saved because name is duplicated";
  public DuplicateCategoryNameException() {
    super(HttpStatus.CONFLICT.value(),
        HttpCodeMessage.CODE409,
        detail,
        HttpStatus.CONFLICT
    );
  }
}
