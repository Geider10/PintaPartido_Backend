package com.pintapartido.backend.club.application.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClubStatusDto {
  @NotBlank(message = "Status is required")
  private String status;
}
