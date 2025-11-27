package com.pintapartido.backend.club.application.useCases.category;

import com.pintapartido.backend.club.domain.models.CategoryModel;
import com.pintapartido.backend.club.domain.respositories.CategoryRepository;
import com.pintapartido.backend.shared.exceptions.NotFoundException;
import java.util.Optional;

public class DeleteCategoryUC {
  private final CategoryRepository categoryRepository;
  public DeleteCategoryUC(CategoryRepository categoryRepository){
    this.categoryRepository = categoryRepository;
  }
  public void execute(Long id){
    Optional<CategoryModel> category = this.categoryRepository.findById(id);
    if (category.isEmpty()) throw new NotFoundException("Category cannot be get by ID because not found");

    this.categoryRepository.deleteById(id);
  }
}
