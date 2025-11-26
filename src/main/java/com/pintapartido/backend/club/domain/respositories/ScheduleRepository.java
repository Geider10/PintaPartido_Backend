package com.pintapartido.backend.club.domain.respositories;

import com.pintapartido.backend.club.domain.models.ScheduleModel;
import java.util.List;
import java.util.Optional;

public interface ScheduleRepository {
  void save(ScheduleModel schedule);
  boolean existsByDayTypeAndClubId(String day, Long clubId);
  List<ScheduleModel> findByClubId(Long clubId);
  Optional<ScheduleModel> findByIdAndClubId(Long id, Long clubId);
  boolean existsByDayTypeAndClubIdAndIdNot(String day, Long clubId, Long id);
  void deleteByIdAndClubId(Long id, Long clubId);
}
