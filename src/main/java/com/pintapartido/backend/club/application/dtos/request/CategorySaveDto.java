package com.pintapartido.backend.club.application.dtos.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CategorySaveDto {
  @NotBlank(message = "Name is required")
  private String name;
}
