package com.pintapartido.backend.club.domain.respositories;

import com.pintapartido.backend.club.domain.models.ScheduleModel;
import java.util.List;

public interface ScheduleRepository {
  void save(ScheduleModel schedule);
  boolean existsByDayTypeAndClubId(String day, Long clubId);
  List<ScheduleModel> findByClubId(Long clubId);
}
