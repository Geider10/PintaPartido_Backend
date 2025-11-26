package com.pintapartido.backend.club.infrastructure.persistence.adapter;

import com.pintapartido.backend.club.domain.models.ScheduleModel;
import com.pintapartido.backend.club.domain.respositories.ScheduleRepository;
import com.pintapartido.backend.club.infrastructure.persistence.entity.ScheduleEntity;
import com.pintapartido.backend.club.infrastructure.persistence.jpa.ScheduleJpaRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ScheduleRepositoryAdapter implements ScheduleRepository {
  private final ScheduleJpaRepository jpa;
  public ScheduleRepositoryAdapter(ScheduleJpaRepository jpa){
    this.jpa = jpa;
  }
  @Override
  public void save(ScheduleModel schedule) {
    ScheduleEntity entity = new ScheduleEntity(
        schedule.getId(),
        schedule.getDayType(),
        schedule.getStartTime(),
        schedule.getEndTime(),
        schedule.getClubId()
    );
    this.jpa.save(entity);
  }
  @Override
  public boolean existsByDayTypeAndClubId(String day, Long clubId) {
    return this.jpa.existsByDayTypeAndClubId(day, clubId);
  }
  @Override
  public List<ScheduleModel> findByClubId(Long clubId) {
    return this.jpa.findByClubId(clubId).stream()
        .map(e -> new ScheduleModel(
            e.getId(),
            e.getDayType(),
            e.getStartTime(),
            e.getEndTime()
        )).toList();
  }
}
