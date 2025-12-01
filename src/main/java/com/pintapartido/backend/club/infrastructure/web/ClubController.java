package com.pintapartido.backend.club.infrastructure.web;

import com.pintapartido.backend.club.application.dtos.request.ClubUpdateDto;
import com.pintapartido.backend.club.application.dtos.response.ClubDetailDto;
import com.pintapartido.backend.club.application.dtos.response.ClubListDto;
import com.pintapartido.backend.club.application.dtos.request.ClubSaveDto;
import com.pintapartido.backend.club.application.dtos.request.ClubStatusDto;
import com.pintapartido.backend.club.application.services.ClubService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clubs")
@Slf4j
public class ClubController {
  private final ClubService clubService;
  public ClubController(ClubService clubService){
    this.clubService = clubService;
  }

  @PostMapping()
  public ResponseEntity<GenericResponseDto<Void>> createClub(@Valid @RequestBody ClubSaveDto dto){
     log.info("POST /api/clubs - Create club");
     this.clubService.createClub(dto);

     return ResponseEntity.status(HttpStatus.CREATED)
             .body(GenericResponseDto.<Void>builder()
                 .code(HttpStatus.CREATED.value())
                 .message("Club created successfully")
                 .build());
  }

  @GetMapping()
  public GenericResponseDto<List<ClubListDto>> getAllClubs(@RequestParam(required = false, defaultValue = "") String status){
    log.info("GET /api/clubs - Get all clubs");
    List<ClubListDto> clubs = clubService.getAllClubs(status);

    return GenericResponseDto.<List<ClubListDto>>builder()
                .code(HttpStatus.OK.value())
                .message("Clubs obtained successfully")
                .data(clubs)
                .build();
  }

  @GetMapping("/{id}")
  public GenericResponseDto<ClubDetailDto> getClubById(@PathVariable Long id){
    log.info("GET /api/clubs/{} - Get club by id", id);
    ClubDetailDto club = this.clubService.getClubById(id);

    return GenericResponseDto.<ClubDetailDto>builder()
                .code(HttpStatus.OK.value())
                .message("Club obtained successfully")
                .data(club)
                .build();
  }

  @PatchMapping("/{id}")
  public GenericResponseDto<Void> updateClub(@PathVariable Long id,@Valid @RequestBody ClubUpdateDto dto){
    log.info("PATCH /api/clubs/{} - Update club by id", id);
    this.clubService.updateClub(id, dto);

    return GenericResponseDto.<Void>builder()
            .code(HttpStatus.OK.value())
            .message("Club updated successfully")
            .build();
  }

  @PatchMapping("/{id}/status")
  public GenericResponseDto<Void> updateClubStatus(@PathVariable Long id, @Valid @RequestBody ClubStatusDto statusDto){
    log.info("PATCH /api/clubs/{}/status - Update club status by id",id);
    this.clubService.updateClubStatus(id, statusDto);

    return GenericResponseDto.<Void>builder()
            .code(HttpStatus.OK.value())
            .message("Club status updated successfully")
            .build();
  }

  @DeleteMapping("/{id}")
  public GenericResponseDto<Void> deleteClubById(@PathVariable Long id){
    log.info("DELETE /api/clubs/{} - Delete club by id", id);
    this.clubService.deleteClubById(id);

    return GenericResponseDto.<Void>builder()
            .code(HttpStatus.OK.value())
            .message("Club deleted successfully")
            .build();
  }
}