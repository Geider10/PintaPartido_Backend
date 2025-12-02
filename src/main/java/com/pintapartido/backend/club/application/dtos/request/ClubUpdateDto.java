package com.pintapartido.backend.club.application.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClubUpdateDto {
  @NotBlank(message = "Name is required")
  @Size(min = 3, max = 100, message = "Name must has between 3 and 100 characters")
  private String name;

  @NotBlank(message = "Address is required")
  @Size(max = 200, message = "Address must has maximum length 200 characters")
  private String address;

  @NotBlank(message = "Location is required")
  @Size(max = 100, message = "Location must has maximum length 100 characters")
  private String location;
}
