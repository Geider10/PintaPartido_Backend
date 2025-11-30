package com.pintapartido.backend.club.application.useCases.schedule;

import com.pintapartido.backend.club.application.dtos.request.ScheduleSaveDto;
import com.pintapartido.backend.club.application.mappers.ScheduleMapper;
import com.pintapartido.backend.club.domain.models.ScheduleModel;
import com.pintapartido.backend.club.domain.respositories.ScheduleRepository;
import com.pintapartido.backend.shared.exceptions.category.ConflictException;

public class CreateScheduleUC {
  private final ScheduleRepository scheduleRepository;
  public CreateScheduleUC(ScheduleRepository scheduleRepository){
    this.scheduleRepository = scheduleRepository;
  }

  public void execute(Long clubId, ScheduleSaveDto dto){
    boolean existsSchedule = this.scheduleRepository.existsByDayTypeAndClubId(dto.getDayType(), clubId);
    if (existsSchedule) throw new ConflictException("Schedule daytype already exists");

    ScheduleModel schedule = ScheduleMapper.convertToModel(clubId, dto);
    this.scheduleRepository.save(schedule);
  }
}
