package com.pintapartido.backend.club.domain.respositories;

import com.pintapartido.backend.club.domain.models.CategoryModel;
import java.util.List;

public interface CategoryRepository {
  void save(CategoryModel category);
  boolean existsByName(String name);
  List<CategoryModel> findAll();
}
