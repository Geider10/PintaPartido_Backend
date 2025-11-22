package com.pintapartido.backend.club.infrastructure.config;

import com.pintapartido.backend.club.application.services.ClubService;
import com.pintapartido.backend.club.domain.respositories.ClubRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración para crear beans de Application inyectando adaptadores de Infraestructura.
 * Aquí "conectamos" el puerto (ClubRepository) con la implementación (ClubRepositoryAdapter)
 * que Spring ya inyectará automáticamente.
 */
@Configuration
public class ClubConfig {
  @Bean
  public ClubService clubService(ClubRepository clubRepository){
    // ClubService está en application y orquesta los use cases.
    // Le pasamos el repository (adapter) que implementa el puerto.
    return new ClubService(clubRepository);
  }
}
