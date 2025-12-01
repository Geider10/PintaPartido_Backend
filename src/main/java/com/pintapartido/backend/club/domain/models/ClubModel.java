package com.pintapartido.backend.club.domain.models;

import com.pintapartido.backend.club.domain.enums.StatusEnum;
import com.pintapartido.backend.shared.exceptions.category.DomainValidationException;

public class ClubModel {
  private Long id;
  private String name;
  private String address;
  private String location;
  private StatusEnum status;
  private Long ownerId;
  //private List<ScheduleModel> schedules;

  public ClubModel(String name, String address, String location, Long ownerId) {
    this.setName(name);
    this.setAddress(address);
    this.setLocation(location);
    this.status = StatusEnum.INACTIVE;
    this.setOwnerId(ownerId);
  }
  public ClubModel(Long id,String name, String address, String location, String status, Long ownerId) {
    this.setId(id);
    this.setName(name);
    this.setAddress(address);
    this.setLocation(location);
    this.setStatus(status);
    this.setOwnerId(ownerId);
  }

  public Long getId() {return this.id;}
  public String getName() {return this.name;}
  public String getAddress() {return this.address;}
  public String getLocation() {return this.location;}
  public String getStatus() {return status.name();}
  public Long getOwnerId() {return this.ownerId;}
  public void setId(Long id){
    this.validateAttributeValue(id, "Id is required");
    this.id = id;
  }
  public void setName(String name) {
    this.validateAttributeValue(name, "Name is required");
    this.name = name;
  }
  public void setAddress(String address) {
    this.validateAttributeValue(address, "Address is required");
    this.address = address;
  }
  public void setLocation(String location) {
    this.validateAttributeValue(location, "Location is required");
    this.location = location;
  }
  public void setStatus(String status){
    this.validateAttributeValue(status, "Status is required");
    this.status = this.formatToStatus(status);
  }
  public void setOwnerId(Long ownerId){
    this.validateAttributeValue(ownerId, "OwnerId is required");
    this.ownerId = ownerId;
  }

  private StatusEnum formatToStatus(String status){
    try{
      return StatusEnum.valueOf(status.toUpperCase());
    }
    catch (IllegalArgumentException ex){
      throw new DomainValidationException("Status format is invalid");
    }
  }
  private void validateAttributeValue(String attribute, String errorMessage){
    if (attribute == null || attribute.isBlank()) throw new DomainValidationException(errorMessage);
  }
  private void validateAttributeValue(Long attribute, String errorMessage){
    if (attribute == null) throw new DomainValidationException(errorMessage);
  }
}
