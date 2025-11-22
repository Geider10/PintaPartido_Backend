package com.pintapartido.backend.club.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClubListDTO {
  private Long id;
  private String name;
  private String location;
}