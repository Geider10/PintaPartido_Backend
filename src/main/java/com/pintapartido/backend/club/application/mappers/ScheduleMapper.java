package com.pintapartido.backend.club.application.mappers;

import com.pintapartido.backend.club.application.dtos.request.ScheduleSaveDto;
import com.pintapartido.backend.club.application.dtos.response.ScheduleListDto;
import com.pintapartido.backend.club.domain.models.ScheduleModel;

public class ScheduleMapper {
  public static ScheduleModel convertToModel(Long clubId, ScheduleSaveDto dto){
    return new ScheduleModel(
        dto.getDayType(),
        dto.getStartTime(),
        dto.getEndTime(),
        clubId
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
  public static void updateToModel(ScheduleModel model, ScheduleSaveDto dto){
    model.setDayType(dto.getDayType());
    model.setStartTime(dto.getStartTime());
    model.setEndTime(dto.getEndTime());
  }
}
