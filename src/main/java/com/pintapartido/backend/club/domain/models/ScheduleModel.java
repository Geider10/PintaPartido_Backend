package com.pintapartido.backend.club.domain.models;

import com.pintapartido.backend.club.domain.enums.DayTypeEnum;
import com.pintapartido.backend.shared.exceptions.InternalServerException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ScheduleModel {
  private Long id;
  private DayTypeEnum dayType;
  private LocalTime startTime;
  private LocalTime endTime;
  private Long clubId;

  public ScheduleModel(String dayType, String startTime, String endTime, Long clubId){
    this.validateAttributeValue(dayType, startTime, endTime, clubId);
    this.dayType = formatToDayType(dayType);
    this.startTime = formatToTime(startTime);
    this.endTime = formatToTime(endTime);
    this.clubId = clubId;
    this.validateStartTime();
  }
  public ScheduleModel(Long id, String dayType, LocalTime startTime, LocalTime endTime){
    this.id = id;
    this.dayType = formatToDayType(dayType);
    this.startTime = startTime;
    this.endTime = endTime;
  }
  public Long getId(){return this.id;}
  public String getDayType(){return this.dayType.name();}
  public LocalTime getStartTime(){return startTime;}
  public LocalTime getEndTime(){return this.endTime;}
  public Long getClubId(){return this.clubId;}

  public String getStartTimeString(){
    return this.startTime.toString();
  }
  public String getEndTimeString(){
    return this.endTime.toString();
  }
  private DayTypeEnum formatToDayType(String dayType) {
    try {
      return DayTypeEnum.valueOf(dayType.toUpperCase());
    }
    catch (IllegalArgumentException ex){
      throw new InternalServerException("Day Type format is invalid");
    }
  }
  private LocalTime formatToTime(String time){
    try {
      return LocalTime.parse(time, DateTimeFormatter.ISO_LOCAL_TIME);
    }
    catch (DateTimeParseException ex){
      throw new InternalServerException("Time format is invalid");
    }
  }
  private void validateStartTime(){
    boolean isPastTime = this.startTime.isBefore(this.endTime);
    if (!isPastTime) throw new InternalServerException("Start time is greater than end time");
  }
  private void validateAttributeValue(String dayType, String startTime, String endTime, Long clubId){
    if (dayType.isBlank()) throw new InternalServerException("Day type is required");
    if (startTime.isBlank()) throw new InternalServerException("Start time is required");
    if (endTime.isBlank()) throw new InternalServerException("End time is required");
    if (clubId == null) throw new InternalServerException("ClubId is required");
  }
}
