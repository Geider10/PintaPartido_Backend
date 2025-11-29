package com.pintapartido.backend.club.application.useCases.category;

import com.pintapartido.backend.club.application.dtos.request.CategorySaveDto;
import com.pintapartido.backend.club.application.mappers.CategoryMapper;
import com.pintapartido.backend.club.domain.models.CategoryModel;
import com.pintapartido.backend.club.domain.respositories.CategoryRepository;
import com.pintapartido.backend.shared.exceptions.category.ConflictException;

public class CreateCategoryUC {
  private final CategoryRepository categoryRepository;
  public CreateCategoryUC(CategoryRepository categoryRepository){
    this.categoryRepository = categoryRepository;
  }
  /**
   * Create a new category if the name doesn't exist.<p>
   *
   * Business rules:<p>
   * - Category name must be uniques within the system.<p>
   *
   * Throws:<p>
   * - ConflictException if category name already exists.
   * @param dto the data the category, not null
   */
  public void execute(CategorySaveDto dto){
    boolean exsitsCategory = this.categoryRepository.existsByName(dto.getName());
    if (exsitsCategory) throw new ConflictException("Category name already exists");

    CategoryModel category = CategoryMapper.convertToModel(dto);
    this.categoryRepository.save(category);
  }
}
