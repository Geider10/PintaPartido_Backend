package com.pintapartido.backend.club.domain.models;

import com.pintapartido.backend.club.domain.enums.CategoryTypeEnum;
import com.pintapartido.backend.shared.exceptions.category.DomainValidationException;

/**
 * Domain model represents a category.<p>
 *
 * Business rules:<p>
 * - The name must match with a value {@link CategoryTypeEnum}.<p>
 * - The name must not be null or blank.<p>
 * - The id must not be bull.<p>
 *
 * Throws DomainValidationException.<p>
 * - The name format is invalid .<p>
 * - The name is null or blank.<p>
 * - The id is null.
 */
public class CategoryModel {
  private Long id;
  private CategoryTypeEnum name;

  /**
   * Creates a new category that validates business rules.
   * @param name the category name, not null
   */
  public CategoryModel(String name){
    this.setName(name);
  }

  /**
   * Creates a category. Used to map objects from persistence.
   * @param id the category id, not null
   * @param name the category name, not null
   */
  public CategoryModel(Long id, String name){
    this.setId(id);
    this.setName(name);
  }

  public Long getId() {return this.id;}
  public String getName() {return this.name.name();}
  public void setId(Long id){
    if (id == null) throw new DomainValidationException("Id is required");
    this.id = id;
  }
  public void setName(String name){
    if (name == null || name.isBlank()) throw new DomainValidationException("Name is required");
    this.name = this.formatToName(name);
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
