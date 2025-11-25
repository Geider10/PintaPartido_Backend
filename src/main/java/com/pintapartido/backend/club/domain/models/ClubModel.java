package com.pintapartido.backend.club.domain.models;

import com.pintapartido.backend.club.domain.enums.StatusEnum;
import com.pintapartido.backend.shared.exceptions.InternalServerException;
import java.util.List;

public class ClubModel {
  private Long id;
  private String name;
  private String address;
  private String location;
  private StatusEnum status;
  private List<ScheduleModel> schedules;

  public ClubModel(String name, String address, String location) {
    this.validateAttributeValue(name, address, location);
    this.name = name;
    this.address = address;
    this.location = location;
    this.status = StatusEnum.INACTIVE;
  }
  public ClubModel(Long id,String name, String address, String location, String status) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.location = location;
    this.status = this.formatToStatus(status);
  }

  public Long getId() {return this.id;}
  public String getName() {return this.name;}
  public String getAddress() {return this.address;}
  public String getLocation() {return this.location;}
  public String getStatus() {return status.name();}

  public void setName(String name) {this.name = name;}
  public void setAddress(String address) {this.address = address;}
  public void setLocation(String location) {this.location = location;}
  public void setStatus(String status){
    if (status.equals("ACTIVE")) this.status = StatusEnum.ACTIVE;
    if (status.equals("INACTIVE")) this.status = StatusEnum.INACTIVE;
    throw new InternalServerException("Status value is invalid");
  }

  private StatusEnum formatToStatus(String status){
    try{
      return StatusEnum.valueOf(status.toUpperCase());
    }
    catch (IllegalArgumentException ex){
      throw new InternalServerException("Status value is invalid");
    }
  }
  private void validateAttributeValue(String name, String address, String location){
    if (name.isBlank()) throw new InternalServerException("Name is required");
    if (address.isBlank()) throw new InternalServerException("Address is required");
    if (location.isBlank()) throw new InternalServerException("Location is required");
  }
}
