package com.pintapartido.backend.club.application.useCases.schedule;

import com.pintapartido.backend.club.application.dtos.request.ScheduleSaveDto;
import com.pintapartido.backend.club.application.mappers.ScheduleMapper;
import com.pintapartido.backend.club.domain.models.ScheduleModel;
import com.pintapartido.backend.club.domain.respositories.ScheduleRepository;
import com.pintapartido.backend.shared.exceptions.category.NotFoundException;
import com.pintapartido.backend.shared.exceptions.category.ConflictException;
import java.util.Optional;

public class UpdateScheduleByClubUC {
  private final ScheduleRepository scheduleRepository;
  public UpdateScheduleByClubUC(ScheduleRepository scheduleRepository){
    this.scheduleRepository = scheduleRepository;
  }

  /**
   *  Update schedule by id and clubId.<p>
   *
   * Business rules:<p>
   * - Schedule must exist within the system.<p>
   * - Schedule dayType must be unique within the system.<p>
   *
   * Throws:<p>
   * - NoFoundException if schedule not found.<p>
   * - ConflictException if schedule dayType already exists.
   * @param id the schedule id, not null
   * @param clubId the schedule clubId, not null
   * @param dto the schedule data, not null
   */
  public void execute(Long id, Long clubId, ScheduleSaveDto dto){
    Optional<ScheduleModel> schedule = this.scheduleRepository.findByIdAndClubId(id, clubId);
    if (schedule.isEmpty()) throw new NotFoundException("Schedule not found by id and club");

    boolean existsSchedule = this.scheduleRepository.existsByDayTypeAndClubIdAndIdNot(dto.getDayType(), clubId, id);
    if (existsSchedule) throw new ConflictException("Schedule daytype already exists");

    ScheduleMapper.updateToModel(schedule.get(), dto);
    this.scheduleRepository.save(schedule.get());
  }

}
