package com.pintapartido.backend.club.application.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClubListDto {
  private Long id;
  private String name;
  private String location;
}