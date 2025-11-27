package com.pintapartido.backend.club.domain.models;

import com.pintapartido.backend.club.domain.enums.CategoryTypeEnum;
import com.pintapartido.backend.shared.exceptions.InternalServerException;

public class CategoryModel {
  private Long id;
  private CategoryTypeEnum name;

  public CategoryModel(String name){
    if (name.isBlank()) throw new InternalServerException("Name is required");
    this.setName(name);
  }

  public Long getId() {return this.id;}
  public String getName() {return this.name.name();}
  public void setName(String name){
    this.name = this.formatToName(name);
  }
  private CategoryTypeEnum formatToName(String name){
    try {
      return CategoryTypeEnum.valueOf(name.toUpperCase());
    }
    catch (IllegalArgumentException ex){
      throw new InternalServerException("Name format is invalid");
    }
  }
}
