package com.pintapartido.backend.club.application.mappers;

import com.pintapartido.backend.club.application.dtos.request.ScheduleSaveDTO;
import com.pintapartido.backend.club.application.dtos.response.ScheduleListDto;
import com.pintapartido.backend.club.domain.models.ScheduleModel;

public class ScheduleMapper {
  public static ScheduleModel convertToModel(ScheduleSaveDTO dto){
    return new ScheduleModel(
        dto.getDayType(),
        dto.getStartTime(),
        dto.getEndTime(),
        dto.getClubId()
    );
  }
  public static ScheduleListDto convertToScheduleList(ScheduleModel model){
    return new ScheduleListDto(
        model.getId(),
        model.getDayType(),
        model.getStartTimeString(),
        model.getEndTimeString()
    );
  }
}
