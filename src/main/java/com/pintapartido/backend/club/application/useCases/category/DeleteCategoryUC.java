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

  /**
   * Delete a category by id.<p>
   *
   * Business rules:<p>
   * - Category must exist within the system.<p>
   *
   * Throws:<p>
   * - NotFoundException if category not found.<p>
   * @param id the category id, not null
   */
  public void execute(Long id){
    Optional<CategoryModel> category = this.categoryRepository.findById(id);
    if (category.isEmpty()) throw new NotFoundException("Category not found by id");

    this.categoryRepository.deleteById(id);
  }
}
