package com.pintapartido.backend.club.infrastructure.config;

import com.pintapartido.backend.club.application.services.CategoryService;
import com.pintapartido.backend.club.domain.respositories.CategoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryConfig {
  @Bean
  public CategoryService categoryService(CategoryRepository categoryRepository){
    return new CategoryService(categoryRepository);
  }
}
