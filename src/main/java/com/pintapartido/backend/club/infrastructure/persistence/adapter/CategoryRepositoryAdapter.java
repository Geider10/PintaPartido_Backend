package com.pintapartido.backend.club.infrastructure.persistence.adapter;

import com.pintapartido.backend.club.domain.models.CategoryModel;
import com.pintapartido.backend.club.domain.respositories.CategoryRepository;
import com.pintapartido.backend.club.infrastructure.persistence.entity.CategoryEntity;
import com.pintapartido.backend.club.infrastructure.persistence.jpa.CategoryJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepositoryAdapter implements CategoryRepository {
  private final CategoryJpaRepository jpa;

  public CategoryRepositoryAdapter(CategoryJpaRepository jpa){
    this.jpa = jpa;
  }

  @Override
  public void save(CategoryModel category) {
    CategoryEntity entity = new CategoryEntity(
        category.getId(),
        category.getName()
    );
    this.jpa.save(entity);
  }

  @Override
  public boolean existsByName(String name) {
    return this.jpa.existsByName(name);
  }
}
