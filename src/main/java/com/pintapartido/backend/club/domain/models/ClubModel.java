package com.pintapartido.backend.club.domain.models;

import com.pintapartido.backend.shared.exceptions.category.DomainValidationException;

/**
 * Domain module represents a club.<p>
 *
 * Business rules:<p>
 * - The attributes are required.<p>
 *
 * Throws DomainException:<p>
 * - Any attribute is null.
 */
public class ClubModel {
  private Long id;
  private String name;
  private String address;
  private String location;
  private Long ownerId;
  //private List<ScheduleModel> schedules;

  /**
   * Creates a new club that validations business rules.
   * @param name the club name, not null
   * @param address the club address, not null
   * @param location the club location, not null
   * @param ownerId the club owner, not null
   */
  public ClubModel(String name, String address, String location, Long ownerId) {
    this.setName(name);
    this.setAddress(address);
    this.setLocation(location);
    this.setOwnerId(ownerId);
  }

  /**
   * Creates a club. Used to map objects from persistence.
   * @param id the club id, not null
   * @param name the club name, not null
   * @param address the club address, not null
   * @param location the club location, not null
   * @param ownerId the club owner, not null
   */
  public ClubModel(Long id,String name, String address, String location, Long ownerId) {
    this.setId(id);
    this.setName(name);
    this.setAddress(address);
    this.setLocation(location);
    this.setOwnerId(ownerId);
  }

  public Long getId() {return this.id;}
  public String getName() {return this.name;}
  public String getAddress() {return this.address;}
  public String getLocation() {return this.location;}
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
  public void setOwnerId(Long ownerId){
    this.validateAttributeValue(ownerId, "OwnerId is required");
    this.ownerId = ownerId;
  }

  private void validateAttributeValue(String attribute, String errorMessage){
    if (attribute == null || attribute.isBlank()) throw new DomainValidationException(errorMessage);
  }
  private void validateAttributeValue(Long attribute, String errorMessage){
    if (attribute == null) throw new DomainValidationException(errorMessage);
  }
}
