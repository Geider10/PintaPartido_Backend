package com.pintapartido.backend.club.infrastructure.config;

import com.pintapartido.backend.club.application.services.ScheduleService;
import com.pintapartido.backend.club.domain.respositories.ClubRepository;
import com.pintapartido.backend.club.domain.respositories.ScheduleRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScheduleConfig {
  @Bean
  public ScheduleService scheduleService(ScheduleRepository scheduleRepository){
    return new ScheduleService(scheduleRepository);
  }
}
