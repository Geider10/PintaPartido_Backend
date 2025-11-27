package com.pintapartido.backend.club.application.services;

import com.pintapartido.backend.club.application.dtos.request.CategorySaveDto;
import com.pintapartido.backend.club.application.dtos.response.CategoryListDto;
import com.pintapartido.backend.club.application.useCases.category.CreateCategoryUC;
import com.pintapartido.backend.club.application.useCases.category.GetAllCategoryUC;
import com.pintapartido.backend.club.application.useCases.category.UpdateCategoryUC;
import com.pintapartido.backend.club.domain.respositories.CategoryRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
  private final CreateCategoryUC createCategoryUC;
  private final GetAllCategoryUC getAllCategoryUC;
  private final UpdateCategoryUC updateCategoryUC;

  public CategoryService(CategoryRepository categoryRepository){
    this.createCategoryUC = new CreateCategoryUC(categoryRepository);
    this.getAllCategoryUC = new GetAllCategoryUC(categoryRepository);
    this.updateCategoryUC = new UpdateCategoryUC(categoryRepository);
  }

  public void createCategory(CategorySaveDto dto){
    this.createCategoryUC.execute(dto);
  }
  public List<CategoryListDto> getAllCategory(){
    return this.getAllCategoryUC.execute();
  }
  public void updateCategory(Long id, CategorySaveDto dto){
    this.updateCategoryUC.execute(id, dto);
  }
}
