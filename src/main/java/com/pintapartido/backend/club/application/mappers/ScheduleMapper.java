package com.pintapartido.backend.club.application.mappers;

import com.pintapartido.backend.club.application.dtos.request.ScheduleSaveDTO;
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
}
