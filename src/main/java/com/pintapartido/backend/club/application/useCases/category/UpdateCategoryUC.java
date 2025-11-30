package com.pintapartido.backend.club.application.useCases.category;

import com.pintapartido.backend.club.application.dtos.request.CategorySaveDto;
import com.pintapartido.backend.club.application.mappers.CategoryMapper;
import com.pintapartido.backend.club.domain.models.CategoryModel;
import com.pintapartido.backend.club.domain.respositories.CategoryRepository;
import com.pintapartido.backend.shared.exceptions.NotFoundException;
import com.pintapartido.backend.shared.exceptions.category.ConflictException;
import java.util.Optional;

public class UpdateCategoryUC {
  private final CategoryRepository categoryRepository;
  public UpdateCategoryUC(CategoryRepository categoryRepository){
    this.categoryRepository = categoryRepository;
  }
  /**
   * Update a category by id.<p>
   *
   * Business rules:<p>
   * - Category must exist within the system.<p>
   * - Category name must be uniques within the system.<p>
   *
   * Throws:<p>
   * - NotFoundException if category not found.<p>
   * - ConflictException if category name already exists.
   * @param id the category id, not nul
   * @param dto the category data, not null
   */
  public void execute(Long id, CategorySaveDto dto){
    Optional<CategoryModel> category = this.categoryRepository.findById(id);
    if (category.isEmpty()) throw new NotFoundException("Category not found by id");

    boolean existsCategory = this.categoryRepository.existsByNameAndIdNot(dto.getName(), id);
    if (existsCategory) throw new ConflictException("Category name already exists");

    CategoryMapper.updateToModel(category.get(), dto);
    this.categoryRepository.save(category.get());
  }
}
