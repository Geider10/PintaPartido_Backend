package com.pintapartido.backend.club.infrastructure.web.impl;

import com.pintapartido.backend.club.application.dtos.request.ScheduleSaveDto;
import com.pintapartido.backend.club.application.dtos.response.ScheduleListDto;
import com.pintapartido.backend.club.application.services.ScheduleService;
import com.pintapartido.backend.club.infrastructure.web.ScheduleController;
import com.pintapartido.backend.shared.dtos.GenericResponseDto;
import jakarta.validation.Valid;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clubs")
@Slf4j
public class ScheduleControllerImpl implements ScheduleController {
  private final ScheduleService scheduleService;
  public ScheduleControllerImpl(ScheduleService scheduleService){
    this.scheduleService = scheduleService;
  }

  @Override
  @PostMapping("/{clubId}/schedules")
  public ResponseEntity<GenericResponseDto<Void>> createSchedule(@PathVariable Long clubId, @Valid @RequestBody ScheduleSaveDto dto){
    log.info("POST /api/clubs/{}/schedules - Create schedule", clubId);
    this.scheduleService.createSchedule(clubId, dto);

    return ResponseEntity.status(HttpStatus.CREATED)
        .body(GenericResponseDto.<Void>builder()
            .code(HttpStatus.CREATED.value())
            .message("Schedule created successfully")
            .build());
  }

  @Override
  @GetMapping("/{clubId}/schedules")
  public GenericResponseDto<List<ScheduleListDto>> getAllScheduleByClubId(@PathVariable Long clubId){
    log.info("GET /api/clubs/{}/schedules - Get all schedules by club", clubId);
    List<ScheduleListDto> schedules = this.scheduleService.getAllScheduleByClubId(clubId);

    return GenericResponseDto.<List<ScheduleListDto>>builder()
            .code(HttpStatus.OK.value())
            .message("Schedule obtained successfully")
            .data(schedules)
            .build();
  }

  @Override
  @PatchMapping("/{clubId}/schedules/{scheduleId}")
  public GenericResponseDto<Void> updateScheduleByClub(@PathVariable Long clubId, @PathVariable Long scheduleId, @Valid @RequestBody ScheduleSaveDto dto){
    log.info("PATCH /api/clubs/{}/schedules/{} - Update schedule by id and club", clubId, scheduleId);
    this.scheduleService.updateScheduleByClub(scheduleId, clubId, dto);

    return GenericResponseDto.<Void>builder()
            .code(HttpStatus.OK.value())
            .message("Schedule updated successfully")
            .build();
  }

  @Override
  @DeleteMapping("/{clubId}/schedules/{scheduleId}")
  public GenericResponseDto<Void> deleteScheduleByClub(@PathVariable Long clubId, @PathVariable Long scheduleId){
    log.info("DELETE /api/clubs/{}/schedules/{} - Delete schedule by id and club", clubId, scheduleId);
    this.scheduleService.deleteScheduleByClub(scheduleId, clubId);

    return GenericResponseDto.<Void>builder()
            .code(HttpStatus.OK.value())
            .message("Schedule deleted successfully")
            .build();
  }
}
