package com.pintapartido.backend.club.domain.models;

import com.pintapartido.backend.club.domain.enums.CategoryTypeEnum;
import com.pintapartido.backend.shared.exceptions.category.DomainValidationException;

public class CategoryModel {
  private Long id;
  private CategoryTypeEnum name;

  public CategoryModel(String name){
    this.setName(name);
  }
  public CategoryModel(Long id, String name){
    this.id = id;
    this.setName(name);
  }

  public Long getId() {return this.id;}
  public String getName() {return this.name.name();}
  public void setName(String name){
    this.validateAttributeValue(name, "Name is required");
    this.name = this.formatToName(name);
  }

  private void validateAttributeValue(String attribute, String errorMessage){
    if (attribute.isBlank()) throw new DomainValidationException(errorMessage);
  }
  private CategoryTypeEnum formatToName(String name){
    try {
      return CategoryTypeEnum.valueOf(name.toUpperCase());
    }
    catch (IllegalArgumentException ex){
      throw new DomainValidationException("Name format is invalid");
    }
  }
}
