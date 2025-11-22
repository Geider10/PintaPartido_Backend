package com.pintapartido.backend.shared.exceptions;

import com.pintapartido.backend.shared.dtos.ErrorResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//Maneja las expeciones de todos los controllers y las convierte en respuestas HTTP
@Slf4j
@RestControllerAdvice
public class ExcepcionHandler {

  @ExceptionHandler(GenericException.class)
  public ResponseEntity<ErrorResponseDto> handleGenericException(GenericException ex){
    log.error("Hanlder GenericException - code:{}, message:{}, detail:{}", ex.getCode(), ex.getMessage(), ex.getDetail(), ex);

    ErrorResponseDto error = ErrorResponseDto.builder()
        .code(ex.getCode())
        .message(ex.getMessage())
        .detail(ex.getDetail())
        .build();

    return ResponseEntity
        .status(ex.getHttpStatus())
        .body(error);
  }
}
