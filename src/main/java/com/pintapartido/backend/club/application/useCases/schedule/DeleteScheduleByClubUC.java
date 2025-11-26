package com.pintapartido.backend.club.application.useCases.schedule;

import com.pintapartido.backend.club.domain.models.ScheduleModel;
import com.pintapartido.backend.club.domain.respositories.ScheduleRepository;
import com.pintapartido.backend.shared.exceptions.NotFoundException;
import java.util.Optional;

public class DeleteScheduleByClubUC {
  private final ScheduleRepository scheduleRepository;
  public DeleteScheduleByClubUC(ScheduleRepository scheduleRepository){
    this.scheduleRepository = scheduleRepository;
  }
  public void execute(Long id, Long clubId){
    Optional<ScheduleModel> schedule = this.scheduleRepository.findByIdAndClubId(id, clubId);
    if (schedule.isEmpty()) throw new NotFoundException("Schedule cannot be get by ID or clubId because was not found.");

    this.scheduleRepository.deleteByIdAndClubId(id, clubId);
  }
}