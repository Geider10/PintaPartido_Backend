package com.pintapartido.backend.club.infrastructure.web;

import com.pintapartido.backend.club.application.dtos.request.ScheduleSaveDTO;
import com.pintapartido.backend.club.application.dtos.request.ScheduleUpdateDto;
import com.pintapartido.backend.club.application.dtos.response.ScheduleListDto;
import com.pintapartido.backend.club.application.services.ScheduleService;
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
  @GetMapping("/club/{clubId}")
  public ResponseEntity<GenericResponseDto<List<ScheduleListDto>>> getAllScheduleByClubId(@PathVariable Long clubId){
    log.info("GET /api/schedules/club/{} - Get all schedules by club id", clubId);
    List<ScheduleListDto> schedules = this.scheduleService.getAllScheduleByClubId(clubId);

    return ResponseEntity.status(HttpStatus.OK)
        .body(GenericResponseDto.<List<ScheduleListDto>>builder()
            .code(HttpStatus.OK.value())
            .message("Schedule obtained successfully")
            .data(schedules)
            .build());
  }
  @PatchMapping("/{id}/club/{clubId}")
  public ResponseEntity<GenericResponseDto<Void>> updateScheduleByClub(@PathVariable Long id, @PathVariable Long clubId,@Valid @RequestBody ScheduleUpdateDto dto){
    log.info("PATCH /api/schedules/{}/club/{} - Update schedule by id and club id",id, clubId);
    this.scheduleService.updateScheduleByClub(id, clubId, dto);

    return ResponseEntity.status(HttpStatus.OK)
        .body(GenericResponseDto.<Void>builder()
            .code(HttpStatus.OK.value())
            .message("Schedule updated successfully")
            .build());
  }
  @DeleteMapping("/{id}/club/{clubId}")
  public ResponseEntity<GenericResponseDto<Void>> deleteScheduleByClub(@PathVariable Long id, @PathVariable Long clubId){
    log.info("DELETE /api/schedules/{}/club/{} - Delete schedule by id and club id", id, clubId);
    this.scheduleService.deleteScheduleByClub(id, clubId);

    return ResponseEntity.status(HttpStatus.OK)
        .body(GenericResponseDto.<Void>builder()
            .code(HttpStatus.OK.value())
            .message("Schedule deleted successfully")
            .build());
  }
}
