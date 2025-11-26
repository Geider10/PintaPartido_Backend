package com.pintapartido.backend.club.application.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleListDto {
  private Long id;
  private String dayType;
  private String startTime;
  private String endTime;
}
