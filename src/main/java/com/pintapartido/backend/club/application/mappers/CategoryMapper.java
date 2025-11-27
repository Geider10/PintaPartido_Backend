package com.pintapartido.backend.club.application.mappers;

import com.pintapartido.backend.club.application.dtos.request.CategorySaveDto;
import com.pintapartido.backend.club.application.dtos.response.CategoryListDto;
import com.pintapartido.backend.club.domain.models.CategoryModel;

public class CategoryMapper {
  public static CategoryModel convertToModel(CategorySaveDto dto){
    return new CategoryModel(
        dto.getName()
    );
  }
  public static CategoryListDto convertToCategoryList(CategoryModel model){
    return new CategoryListDto(
        model.getId(),
        model.getName()
    );
  }
  public static void updateToModel(CategoryModel model, CategorySaveDto dto){
    model.setName(dto.getName());
  }
}
