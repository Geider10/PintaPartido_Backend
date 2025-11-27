package com.pintapartido.backend.club.application.useCases.schedule;

import com.pintapartido.backend.club.application.dtos.request.ScheduleSaveDTO;
import com.pintapartido.backend.club.application.mappers.ScheduleMapper;
import com.pintapartido.backend.club.domain.exceptions.DuplicateScheduleDayException;
import com.pintapartido.backend.club.domain.models.ScheduleModel;
import com.pintapartido.backend.club.domain.respositories.ScheduleRepository;

public class CreateScheduleUC {
  private final ScheduleRepository scheduleRepository;
  public CreateScheduleUC(ScheduleRepository scheduleRepository){this.scheduleRepository = scheduleRepository;}

  public void execute(ScheduleSaveDTO dto){
    boolean existsSchedule = this.scheduleRepository.existsByDayTypeAndClubId(dto.getDayType(), dto.getClubId());
    if (existsSchedule) throw new DuplicateScheduleDayException();

    ScheduleModel schedule = ScheduleMapper.convertToModel(dto);
    this.scheduleRepository.save(schedule);
  }
}
