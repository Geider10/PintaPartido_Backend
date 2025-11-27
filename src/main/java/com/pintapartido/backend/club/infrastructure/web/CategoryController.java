package com.pintapartido.backend.club.infrastructure.web;

import com.pintapartido.backend.club.application.dtos.request.CategorySaveDto;
import com.pintapartido.backend.club.application.dtos.response.CategoryListDto;
import com.pintapartido.backend.club.application.services.CategoryService;
import com.pintapartido.backend.shared.dtos.GenericResponseDto;
import jakarta.validation.Valid;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
@Slf4j
public class CategoryController {
  private final CategoryService categoryService;
  public CategoryController(CategoryService categoryService){
    this.categoryService = categoryService;
  }
  @PostMapping()
  public ResponseEntity<GenericResponseDto<Void>> createCategory(@Valid @RequestBody CategorySaveDto dto){
    log.info("POST /api/categories - Create category");
    this.categoryService.createCategory(dto);

    return ResponseEntity.status(HttpStatus.CREATED)
        .body(GenericResponseDto.<Void>builder()
            .code(HttpStatus.CREATED.value())
            .message("Category created successfully")
            .build());
  }
  @GetMapping()
  public GenericResponseDto<List<CategoryListDto>> getAllCategory(){
    log.info("GET /api/categories - Get all categories");
    List<CategoryListDto> categories = this.categoryService.getAllCategory();

    return GenericResponseDto.<List<CategoryListDto>>builder()
        .code(HttpStatus.OK.value())
        .message("Category obtained successfully")
        .data(categories)
        .build();
  }
  @PatchMapping("/{id}")
  public GenericResponseDto<Void> updateCategory(@PathVariable Long id, @Valid @RequestBody CategorySaveDto dto){
    log.info("PATCH /api/categories/{} - Update category by id", id);
    this.categoryService.updateCategory(id, dto);

    return GenericResponseDto.<Void>builder()
        .code(HttpStatus.OK.value())
        .message("Category updated successfully")
        .build();
  }
  @DeleteMapping("/{id}")
  public GenericResponseDto<Void> deleteCategory(@PathVariable Long id){
    log.info("DELETE /api/categories/{} - Delete category by id", id);
    this.categoryService.deleteCategory(id);

    return GenericResponseDto.<Void>builder()
        .code(HttpStatus.OK.value())
        .message("Category deleted successfully")
        .build();
  }
}
