package com.pintapartido.backend.club.application.services;

import com.pintapartido.backend.club.application.dtos.request.CategorySaveDto;
import com.pintapartido.backend.club.application.useCases.category.CreateCategoryUC;
import com.pintapartido.backend.club.domain.respositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
  private final CreateCategoryUC createCategoryUC;

  public CategoryService(CategoryRepository categoryRepository){
    this.createCategoryUC = new CreateCategoryUC(categoryRepository);
  }

  public void createCategory(CategorySaveDto dto){
    this.createCategoryUC.execute(dto);
  }
}
