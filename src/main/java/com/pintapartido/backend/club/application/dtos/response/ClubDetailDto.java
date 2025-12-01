package com.pintapartido.backend.club.application.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClubDetailDto {
  private Long id;
  private String name;
  private String address;
  private String location;
  private String status;
}
