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

  @Operation(summary = "Create category", description = "Create a new category")
  @ApiResponses({
      @ApiResponse(responseCode = "201", description = "Category created successfully"),
      @ApiResponse(responseCode = "409", description = "Category name already exists"),
      @ApiResponse(responseCode = "422", description = "Name format is invalid")
  })
  ResponseEntity<GenericResponseDto<Void>> createCategory(CategorySaveDto dto);

  @Operation(summary = "Find categories", description = "Find all categories")
  @ApiResponse(responseCode = "200", description = "Category obtained successfully")
  GenericResponseDto<List<CategoryListDto>> getAllCategory();

  @Operation(summary = "Update category", description = "Update a category by id")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Category updated successfully"),
      @ApiResponse(responseCode = "404", description = "Category not found"),
      @ApiResponse(responseCode = "409", description = "Category name already exists"),
      @ApiResponse(responseCode = "422", description = "Name format is invalid")
  })
  GenericResponseDto<Void> updateCategory(Long id, CategorySaveDto dto);

  @Operation(summary = "Delete category", description = "Delete a category by id")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Category deleted successfully"),
      @ApiResponse(responseCode = "404", description = "Category not found"),
  })
  GenericResponseDto<Void> deleteCategory(Long id);
}
