package com.pintapartido.backend.shared.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GenericResponseDto<T> {
  private Integer code;
  private String message;
  private T data;
}
