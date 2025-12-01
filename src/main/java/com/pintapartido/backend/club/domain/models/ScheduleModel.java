package com.pintapartido.backend.club.domain.models;

import com.pintapartido.backend.club.domain.enums.DayTypeEnum;
import com.pintapartido.backend.shared.exceptions.category.DomainValidationException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Domain model represents a schedule.
 *
 * Business rules:
 * - The dayType must match with a value {@link DayTypeEnum}.
 * - The startTime must be less that endTime.
 * - The startTime o endTime value must be permitted.
 * - The attributes must not be null.
 *
 * Trows DomainException:
 * - The dayType format is invalid.
 * - The startTime is greater than endTime.
 * - The startTime or endTime value is not permitted.
 * - Any attribute is null.
 */
public class ScheduleModel {
  private Long id;
  private DayTypeEnum dayType;
  private LocalTime startTime;
  private LocalTime endTime;
  private Long clubId;

  /**
   * Creates a new schedule that validates business rules.
   * @param dayType the schedule dayType, not null
   * @param startTime the schedule startTime, not null
   * @param endTime the schedule endTime, not null
   * @param clubId the schedule clubId, not null
   */
  public ScheduleModel(String dayType, String startTime, String endTime, Long clubId){
    this.setDayType(dayType);
    this.setStartTime(startTime);
    this.setEndTime(endTime);
    this.clubId = clubId;
  }

  /**
   * Creates a schedule. Used to map objects from persistence.
   * @param id the schedule id, not null
   * @param dayType the schedule dayTpe, not null
   * @param startTime the schedule startTime, not null
   * @param endTime the schedule endTime, not null
   * @param clubId the schedule clubId, not null
   */
  public ScheduleModel(Long id, String dayType, LocalTime startTime, LocalTime endTime, Long clubId){
    this.setId(id);
    this.setDayType(dayType);
    this.startTime = startTime;
    this.endTime = endTime;
    this.setClubId(clubId);
  }

  public Long getId(){return this.id;}
  public String getDayType(){return this.dayType.name();}
  public LocalTime getStartTime(){return this.startTime;}
  public LocalTime getEndTime(){return this.endTime;}
  public Long getClubId(){return this.clubId;}
  public void setId(Long id){
    this.validateAttributeValue(id, "Id is required");
    this.id = id;
  }
  public void setDayType(String dayType){
    this.validateAttributeValue(dayType, "DayType is required");
    this.dayType = this.formatToDayType(dayType);
  }
  public void setStartTime(String startTime){
    this.validateAttributeValue(startTime, "StartTime is required");
    this.startTime = this.formatToTime(startTime);
    this.validateStartTimeMin();
  }
  public void setEndTime(String endTime){
    this.validateAttributeValue(endTime, "EndTime is required");
    this.endTime = this.formatToTime(endTime);
    this.validateEndTimeMax();
    this.validateTimeConsistency();
  }
  public void setClubId(Long clubId){
    this.validateAttributeValue(clubId, "ClubId is required");
    this.clubId = clubId;
  }
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
      throw new DomainValidationException("DayType format is invalid");
    }
  }
  private LocalTime formatToTime(String time){
    try {
      return LocalTime.parse(time, DateTimeFormatter.ISO_LOCAL_TIME);
    }
    catch (DateTimeParseException ex){
      throw new DomainValidationException("Time format is invalid");
    }
  }
  private void validateTimeConsistency(){
    boolean isAfterTime = this.startTime.isAfter(this.endTime);
    if (isAfterTime) throw new DomainValidationException("Start time is greater than end time");
  }
  private void validateStartTimeMin(){
    LocalTime minimumTime = LocalTime.parse("05:59");
    boolean isPermittedTime = this.startTime.isAfter(minimumTime);
    if (!isPermittedTime) throw new DomainValidationException("Start time is less than permitted");
  }
  private void validateEndTimeMax(){
    LocalTime maximumTime = LocalTime.parse("23:59");
    boolean isPermittedTime = this.endTime.isBefore(maximumTime);
    if (!isPermittedTime) throw new DomainValidationException("End time is greater than permitted");
  }
  private void validateAttributeValue(String attribute, String message){
    if (attribute == null || attribute.isBlank()) throw new DomainValidationException(message);
  }
  private void validateAttributeValue(Long attribute, String message){
    if (attribute == null) throw new DomainValidationException(message);
  }
}
