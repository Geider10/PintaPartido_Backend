package com.pintapartido.backend.club.application.useCases.schedule;

import com.pintapartido.backend.club.domain.models.ScheduleModel;
import com.pintapartido.backend.club.domain.respositories.ScheduleRepository;
import com.pintapartido.backend.shared.exceptions.category.NotFoundException;
import java.util.Optional;

public class DeleteScheduleByClubUC {
  private final ScheduleRepository scheduleRepository;
  public DeleteScheduleByClubUC(ScheduleRepository scheduleRepository){
    this.scheduleRepository = scheduleRepository;
  }

  /**
   * Delete schedule by id.<p>
   *
   * Business rules:<p>
   * - Schedule must exist within the system.<p>
   *
   * Throws:<p>
   * - NoFoundException if schedule not found.
   * @param id the schedule id, not null
   * @param clubId the schedule clubId, not null
   */
  public void execute(Long id, Long clubId){
    Optional<ScheduleModel> schedule = this.scheduleRepository.findByIdAndClubId(id, clubId);
    if (schedule.isEmpty()) throw new NotFoundException("Schedule not found by id and club");

    this.scheduleRepository.deleteByIdAndClubId(id, clubId);
  }
}