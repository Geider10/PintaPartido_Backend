package com.pintapartido.backend.club.infrastructure.persistence.jpa;

import com.pintapartido.backend.club.infrastructure.persistence.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleJpaRepository extends JpaRepository<ScheduleEntity, Long> {
  boolean existsByDayTypeAndClubId(String day, Long clubId);
}
