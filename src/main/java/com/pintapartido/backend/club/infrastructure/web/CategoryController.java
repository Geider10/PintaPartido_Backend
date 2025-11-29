package com.pintapartido.backend.club.infrastructure.web;

import com.pintapartido.backend.club.application.dtos.request.CategorySaveDto;
import com.pintapartido.backend.club.application.dtos.response.CategoryListDto;
import com.pintapartido.backend.shared.dtos.GenericResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.http.ResponseEntity;

@Tag(name = "Category")
public interface CategoryController {

  @Operation(summary = "Create category", description = "Create a new category if the name doesn't exist")
  @ApiResponses({
      @ApiResponse(responseCode = "201", description = "Category created"),
      @ApiResponse(responseCode = "409", description = "Category name already exists"),
      @ApiResponse(responseCode = "422", description = "Category name format is invalid")
  })
  ResponseEntity<GenericResponseDto<Void>> createCategory(CategorySaveDto dto);

  @Operation(summary = "Find categories", description = "Find all categories if there is stored data.")
  @ApiResponse(responseCode = "200", description = "Category obtained")
  GenericResponseDto<List<CategoryListDto>> getAllCategory();

  @Operation(summary = "Update category", description = "Update a category by id if the category is found and the name does not exist")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Category updated"),
      @ApiResponse(responseCode = "404", description = "Category not found"),
      @ApiResponse(responseCode = "409", description = "Category name already exists"),
      @ApiResponse(responseCode = "422", description = "Category name format is invalid")
  })
  GenericResponseDto<Void> updateCategory(Long id, CategorySaveDto dto);

  @Operation(summary = "Delete category", description = "Delete a category by id if the category is found.")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Category deleted"),
      @ApiResponse(responseCode = "404", description = "Category not found"),
  })
  GenericResponseDto<Void> deleteCategory(Long id);
}
