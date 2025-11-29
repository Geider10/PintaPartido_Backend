package com.pintapartido.backend.club.application.useCases.category;

import com.pintapartido.backend.club.application.dtos.response.CategoryListDto;
import com.pintapartido.backend.club.application.mappers.CategoryMapper;
import com.pintapartido.backend.club.domain.models.CategoryModel;
import com.pintapartido.backend.club.domain.respositories.CategoryRepository;
import java.util.List;

public class GetAllCategoryUC {
  private final CategoryRepository categoryRepository;
  public GetAllCategoryUC(CategoryRepository categoryRepository){
    this.categoryRepository = categoryRepository;
  }
  /**
   * Get all categories if there is stored data.
   * @return a list of categories
   */
  public List<CategoryListDto> execute(){
    List<CategoryModel> categories = this.categoryRepository.findAll();

    return categories.stream()
        .map(m -> CategoryMapper.convertToCategoryList(m))
        .toList();
  }
}
