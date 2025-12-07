package com.pintapartido.backend.club.infrastructure.web;

import com.pintapartido.backend.club.application.dtos.request.ScheduleSaveDto;
import com.pintapartido.backend.club.application.dtos.response.ScheduleListDto;
import com.pintapartido.backend.shared.dtos.GenericResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.http.ResponseEntity;

@Tag(name = "Schedule")
public interface ScheduleController {

  @Operation(summary = "Create schedule", description = "Create a new schedule")
  @ApiResponses({
      @ApiResponse(responseCode = "201", description = "Schedule created successfully"),
      @ApiResponse(responseCode = "409", description = "Schedule dayType already exists"),
      @ApiResponse(
          responseCode = "422",
          description = """
              Validation errors:
              - DayType format is invalid
              - StartTime or endTime value is not permitted
              """)
  })
  ResponseEntity<GenericResponseDto<Void>> createSchedule(Long clubId, ScheduleSaveDto dto);

  @Operation(summary = "Get schedules", description = "Get all schedules by clubId")
  @ApiResponse(responseCode = "200", description = "Schedules obtained successfully")
  GenericResponseDto<List<ScheduleListDto>> getAllScheduleByClubId(Long clubId);

  @Operation(summary = "Update schedule", description = "Update a schedule by id")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Schedule updated successfully"),
      @ApiResponse(responseCode = "404", description = "Schedule not found"),
      @ApiResponse(responseCode = "409", description = "Schedule dayType already exists"),
      @ApiResponse(
          responseCode = "422",
          description = """
              Validation errors:
              - DayType format is invalid
              - StartTime or endTime value is not permitted
              """)
  })
  GenericResponseDto<Void> updateScheduleByClub(Long clubId, Long scheduleId, ScheduleSaveDto dto);

  @Operation(summary = "Delete schedule", description = "Delete a schedule by id")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Schedule deleted successfully"),
      @ApiResponse(responseCode = "404", description = "Schedule not found")
  })
  GenericResponseDto<Void> deleteScheduleByClub(Long clubId, Long scheduleId);
}
