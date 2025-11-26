package com.pintapartido.backend.club.application.services;

import com.pintapartido.backend.club.application.dtos.request.ScheduleSaveDTO;
import com.pintapartido.backend.club.application.dtos.request.ScheduleUpdateDto;
import com.pintapartido.backend.club.application.dtos.response.ScheduleListDto;
import com.pintapartido.backend.club.application.useCases.schedule.CreateScheduleUC;
import com.pintapartido.backend.club.application.useCases.schedule.GetAllScheduleByClubIdUC;
import com.pintapartido.backend.club.application.useCases.schedule.UpdateScheduleByClubUC;
import com.pintapartido.backend.club.domain.respositories.ScheduleRepository;
import java.util.List;

public class ScheduleService {
  private final CreateScheduleUC createUC;
  private final GetAllScheduleByClubIdUC getAllUC;
  private final UpdateScheduleByClubUC updateUC;

  public ScheduleService(ScheduleRepository scheduleRepository) {
    this.createUC = new CreateScheduleUC(scheduleRepository);
    this.getAllUC = new GetAllScheduleByClubIdUC(scheduleRepository);
    this.updateUC = new UpdateScheduleByClubUC(scheduleRepository);
  }

  public void createSchedule(ScheduleSaveDTO dto){
    this.createUC.execute(dto);
  }
  public List<ScheduleListDto> getAllScheduleByClubId(Long clubId){
    return this.getAllUC.execute(clubId);
  }
  public void updateScheduleByClub(Long id, Long clubId, ScheduleUpdateDto dto){
    this.updateUC.execute(id, clubId, dto);
  }
}
