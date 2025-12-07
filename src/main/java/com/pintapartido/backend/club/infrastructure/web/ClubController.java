package com.pintapartido.backend.club.infrastructure.web;

import com.pintapartido.backend.club.application.dtos.request.ClubSaveDto;
import com.pintapartido.backend.club.application.dtos.request.ClubUpdateDto;
import com.pintapartido.backend.club.application.dtos.response.ClubDetailDto;
import com.pintapartido.backend.club.application.dtos.response.ClubListDto;
import com.pintapartido.backend.shared.dtos.GenericResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.http.ResponseEntity;

@Tag(name = "Club")
public interface ClubController {
  @Operation(summary = "Create club", description = "Create a new club")
  @ApiResponses({
      @ApiResponse(responseCode = "201", description = "Club created successfully"),
      @ApiResponse(responseCode = "409", description = "Club name and address already exists")
  })
  ResponseEntity<GenericResponseDto<Void>> createClub(ClubSaveDto dto);

  @Operation(summary = "Get clubs", description = "Get all clubs.")
  @ApiResponse(responseCode = "200", description = "Club obtained successfully")
  GenericResponseDto<List<ClubListDto>> getAllClubs();

  @Operation(summary = "Get club", description = "Get a club by id")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Club obtained successfully"),
      @ApiResponse(responseCode = "404", description = "Club not found")
  })
  GenericResponseDto<ClubDetailDto> getClubById(Long id);

  @Operation(summary = "Update club", description = "Update a club by id")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Club updated successfully"),
      @ApiResponse(responseCode = "404", description = "Club not found"),
      @ApiResponse(responseCode = "409", description = "Club name and address already exists")
  })
  GenericResponseDto<Void> updateClub(Long id, ClubUpdateDto dto);

  @Operation(summary = "Delete club", description = "Delete a club by id")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Club deleted successfully"),
      @ApiResponse(responseCode = "404", description = "Club not found")
  })
  GenericResponseDto<Void> deleteClubById(Long id);
}
