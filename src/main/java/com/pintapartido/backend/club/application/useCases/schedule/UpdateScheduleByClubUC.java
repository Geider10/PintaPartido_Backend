package com.pintapartido.backend.club.application.useCases.schedule;

import com.pintapartido.backend.club.application.dtos.request.ScheduleUpdateDto;
import com.pintapartido.backend.club.application.mappers.ScheduleMapper;
import com.pintapartido.backend.club.domain.exceptions.DuplicateScheduleDayException;
import com.pintapartido.backend.club.domain.models.ScheduleModel;
import com.pintapartido.backend.club.domain.respositories.ScheduleRepository;
import com.pintapartido.backend.shared.exceptions.NotFoundException;
import java.util.Optional;

public class UpdateScheduleByClubUC {
  private final ScheduleRepository scheduleRepository;
  public UpdateScheduleByClubUC(ScheduleRepository scheduleRepository){
    this.scheduleRepository = scheduleRepository;
  }
  public void execute(Long id, Long clubId, ScheduleUpdateDto dto){
    Optional<ScheduleModel> schedule = this.scheduleRepository.findByIdAndClubId(id, clubId);
    if (schedule.isEmpty()) throw new NotFoundException("Schedule cannot be get by ID or clubId because was not found.");

    boolean existsSchedule = this.scheduleRepository.existsByDayTypeAndClubIdAndIdNot(dto.getDayType(), clubId, id);
    if (existsSchedule) throw new DuplicateScheduleDayException();

    ScheduleMapper.updateToModel(schedule.get(), dto);
    this.scheduleRepository.save(schedule.get());
  }

}
