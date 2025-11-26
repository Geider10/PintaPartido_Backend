package com.pintapartido.backend.club.application.useCases.schedule;

import com.pintapartido.backend.club.application.dtos.response.ScheduleListDto;
import com.pintapartido.backend.club.application.mappers.ScheduleMapper;
import com.pintapartido.backend.club.domain.models.ScheduleModel;
import com.pintapartido.backend.club.domain.respositories.ScheduleRepository;
import java.util.List;

public class GetAllScheduleByClubIdUC {
  private final ScheduleRepository scheduleRepository;
  public GetAllScheduleByClubIdUC(ScheduleRepository scheduleRepository){
    this.scheduleRepository = scheduleRepository;
  }

  public List<ScheduleListDto> execute(Long clubId){
    List<ScheduleModel> schedules = this.scheduleRepository.findByClubId(clubId);

    return schedules.stream()
        .map(m -> ScheduleMapper.convertToScheduleList(m)).
        toList();
  }
}
