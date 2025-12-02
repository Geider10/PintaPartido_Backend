package com.pintapartido.backend.club.application.services;

import com.pintapartido.backend.club.application.dtos.request.ScheduleSaveDto;
import com.pintapartido.backend.club.application.dtos.response.ScheduleListDto;
import com.pintapartido.backend.club.application.useCases.schedule.CreateScheduleUC;
import com.pintapartido.backend.club.application.useCases.schedule.DeleteScheduleByClubUC;
import com.pintapartido.backend.club.application.useCases.schedule.GetAllScheduleByClubUC;
import com.pintapartido.backend.club.application.useCases.schedule.UpdateScheduleByClubUC;
import com.pintapartido.backend.club.domain.respositories.ScheduleRepository;
import jakarta.transaction.Transactional;
import java.util.List;

public class ScheduleService {
  private final CreateScheduleUC createScheduleUC;
  private final GetAllScheduleByClubUC getAllScheduleByClubUC;
  private final UpdateScheduleByClubUC updateScheduleByClubUC;
  private final DeleteScheduleByClubUC deleteScheduleByClubUC;

  public ScheduleService(ScheduleRepository scheduleRepository) {
    this.createScheduleUC = new CreateScheduleUC(scheduleRepository);
    this.getAllScheduleByClubUC = new GetAllScheduleByClubUC(scheduleRepository);
    this.updateScheduleByClubUC = new UpdateScheduleByClubUC(scheduleRepository);
    this.deleteScheduleByClubUC = new DeleteScheduleByClubUC(scheduleRepository);
  }

  public void createSchedule(Long clubId, ScheduleSaveDto dto){
    this.createScheduleUC.execute(clubId, dto);
  }
  public List<ScheduleListDto> getAllScheduleByClubId(Long clubId){
    return this.getAllScheduleByClubUC.execute(clubId);
  }
  public void updateScheduleByClub(Long id, Long clubId, ScheduleSaveDto dto){
    this.updateScheduleByClubUC.execute(id, clubId, dto);
  }
  @Transactional
  public void deleteScheduleByClub(Long id, Long clubId){
    this.deleteScheduleByClubUC.execute(id, clubId);
  }
}
