package com.pintapartido.backend.club.domain.respositories;

import com.pintapartido.backend.club.domain.models.ScheduleModel;

public interface ScheduleRepository {
  void save(ScheduleModel schedule);
  boolean existsByDayTypeAndClubId(String day, Long clubId);
}
