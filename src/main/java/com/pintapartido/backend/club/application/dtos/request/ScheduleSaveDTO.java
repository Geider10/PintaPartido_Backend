package com.pintapartido.backend.club.application.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleSaveDTO {
  @NotBlank(message = "Day type is required")
  private String dayType;

  @NotBlank(message = "Start time is required")
  @Pattern(regexp = "^(?:[01]\\d|2[0-3]):[0-5]\\d$", message = "Start time must have valid format")
  private String startTime;

  @NotBlank(message = "End time is required")
  @Pattern(regexp = "^(?:[01]\\d|2[0-3]):[0-5]\\d$", message = "End time must have valid format")
  private String endTime;

  @NotNull(message = "Club id is required")
  @Positive(message = "Club id must be positive number")
  private Long clubId;
}
