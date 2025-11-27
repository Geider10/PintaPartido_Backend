package com.pintapartido.backend.club.infrastructure.persistence.jpa;

import com.pintapartido.backend.club.infrastructure.persistence.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryJpaRepository extends JpaRepository<CategoryEntity, Long> {
  boolean existsByName(String name);
  boolean existsByNameAndIdNot(String name, Long id);
}
