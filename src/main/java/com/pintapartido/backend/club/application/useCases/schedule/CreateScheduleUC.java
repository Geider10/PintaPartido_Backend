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

  /**
   * Create a new schedule.<p>
   *
   * Business rules:<p>
   * - Schedule dayType must be unique within the system.<p>
   *
   * Throws:<p>
   * - ConflictException if schedule dayType already exists.
   * @param clubId the schedule clubId, not null
   * @param dto the schedule data, not null
   */
  public void execute(Long clubId, ScheduleSaveDto dto){
    boolean existsSchedule = this.scheduleRepository.existsByDayTypeAndClubId(dto.getDayType(), clubId);
    if (existsSchedule) throw new ConflictException("Schedule daytype already exists");

    ScheduleModel schedule = ScheduleMapper.convertToModel(clubId, dto);
    this.scheduleRepository.save(schedule);
  }
}
