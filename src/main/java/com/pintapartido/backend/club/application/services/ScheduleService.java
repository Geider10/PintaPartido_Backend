package com.pintapartido.backend.club.application.services;

import com.pintapartido.backend.club.application.dtos.request.ScheduleSaveDTO;
import com.pintapartido.backend.club.application.dtos.response.ScheduleListDto;
import com.pintapartido.backend.club.application.useCases.schedule.CreateScheduleUC;
import com.pintapartido.backend.club.application.useCases.schedule.GetAllScheduleByClubIdUC;
import com.pintapartido.backend.club.domain.respositories.ScheduleRepository;
import java.util.List;

public class ScheduleService {
  private final CreateScheduleUC createUC;
  private final GetAllScheduleByClubIdUC getAllUC;

  public ScheduleService(ScheduleRepository scheduleRepository) {
    this.createUC = new CreateScheduleUC(scheduleRepository);
    this.getAllUC = new GetAllScheduleByClubIdUC(scheduleRepository);
  }

  public void createSchedule(ScheduleSaveDTO dto){
    this.createUC.execute(dto);
  }
  public List<ScheduleListDto> getAllScheduleByClubId(Long clubId){
    return this.getAllUC.execute(clubId);
  }
}
