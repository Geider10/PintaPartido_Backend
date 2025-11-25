package com.pintapartido.backend.club.application.services;

import com.pintapartido.backend.club.application.dtos.request.ScheduleSaveDTO;
import com.pintapartido.backend.club.application.useCases.schedule.CreateScheduleUC;
import com.pintapartido.backend.club.domain.respositories.ScheduleRepository;

public class ScheduleService {

  private final CreateScheduleUC createUC;

  public ScheduleService(ScheduleRepository scheduleRepository) {
    this.createUC = new CreateScheduleUC(scheduleRepository);
  }

  public void createSchedule(ScheduleSaveDTO dto){
    this.createUC.execute(dto);
  }
}
