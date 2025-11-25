package com.pintapartido.backend.club.infrastructure.web;

import com.pintapartido.backend.club.application.dtos.request.ScheduleSaveDTO;
import com.pintapartido.backend.club.application.services.ScheduleService;
import com.pintapartido.backend.shared.dtos.GenericResponseDto;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/schedules")
@Slf4j
public class ScheduleController {
  private final ScheduleService scheduleService;
  public ScheduleController(ScheduleService scheduleService){
    this.scheduleService = scheduleService;
  }

  @PostMapping()
  public ResponseEntity<GenericResponseDto<Void>> createSchedule(@Valid @RequestBody ScheduleSaveDTO dto){
    log.info("POST /api/schedules - Create schedule");
    this.scheduleService.createSchedule(dto);

    return ResponseEntity.status(HttpStatus.CREATED)
        .body(GenericResponseDto.<Void>builder()
            .code(HttpStatus.CREATED.value())
            .message("Schedule created successfully")
            .build());
  }
}
