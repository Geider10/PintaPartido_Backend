package com.pintapartido.backend.club.infrastructure.persistence.jpa;

import com.pintapartido.backend.club.infrastructure.persistence.entity.ScheduleEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleJpaRepository extends JpaRepository<ScheduleEntity, Long> {
  boolean existsByDayTypeAndClubId(String day, Long clubId);
  List<ScheduleEntity> findByClubId(Long clubId);
  Optional<ScheduleEntity> findByIdAndClubId(Long id, Long clubId);
  boolean existsByDayTypeAndClubIdAndIdNot(String day, Long clubId, Long id);
  void deleteByIdAndClubId(Long id, Long clubId);
}
