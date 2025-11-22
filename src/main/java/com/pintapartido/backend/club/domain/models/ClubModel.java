package com.pintapartido.backend.club.domain.models;

import com.pintapartido.backend.club.domain.enums.StatusEnum;

public class ClubModel {
  private Long id;
  private String name;
  private String address;
  private String location;
  private StatusEnum status;

  public ClubModel(String name, String address, String location) {
    //Validaciones para tests
    if (name == null || name.isBlank()) throw new RuntimeException("Name is required");
    if (address == null || address.isBlank()) throw new RuntimeException("Address is required");
    if (location == null || location.isBlank()) throw new RuntimeException("Location is required");

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
    this.status = getStatus(status);
  }
  public Long getId() {return this.id;}
  public String getName() {return this.name;}
  public String getAddress() {return this.address;}
  public String getLocation() {return this.location;}
  public String getStatus() {return status.name();}
  public StatusEnum getStatus(String status){
    if (status.equals("ACTIVE")) return StatusEnum.ACTIVE;
    if (status.equals("INACTIVE")) return StatusEnum.INACTIVE;
    throw new RuntimeException("Status must be ACTIVE or INACTIVE");
  }
  public void setName(String name) {this.name = name;}
  public void setAddress(String address) {this.address = address;}
  public void setLocation(String location) {this.location = location;}
  public void setStatus(String status){
    if (status.equals("ACTIVE")) this.status = StatusEnum.ACTIVE;
    if (status.equals("INACTIVE")) this.status = StatusEnum.INACTIVE;
  }
}
