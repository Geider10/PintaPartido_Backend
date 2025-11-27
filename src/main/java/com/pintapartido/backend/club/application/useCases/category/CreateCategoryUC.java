package com.pintapartido.backend.club.application.useCases.category;

import com.pintapartido.backend.club.application.dtos.request.CategorySaveDto;
import com.pintapartido.backend.club.application.mappers.CategoryMapper;
import com.pintapartido.backend.club.domain.exceptions.DuplicateCategoryNameException;
import com.pintapartido.backend.club.domain.models.CategoryModel;
import com.pintapartido.backend.club.domain.respositories.CategoryRepository;

public class CreateCategoryUC {
  private final CategoryRepository categoryRepository;
  public CreateCategoryUC(CategoryRepository categoryRepository){
    this.categoryRepository = categoryRepository;
  }

  public void execute(CategorySaveDto dto){
    boolean exsitsCategory = this.categoryRepository.existsByName(dto.getName());
    if (exsitsCategory) throw new DuplicateCategoryNameException();

    CategoryModel category = CategoryMapper.convertToModel(dto);
    this.categoryRepository.save(category);
  }
}
