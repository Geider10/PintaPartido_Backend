package com.pintapartido.backend.club.infrastructure.web;

import com.pintapartido.backend.club.application.dtos.ClubDetailDTO;
import com.pintapartido.backend.club.application.dtos.ClubListDTO;
import com.pintapartido.backend.club.application.dtos.ClubSaveDTO;
import com.pintapartido.backend.club.application.dtos.ClubStatusDto;
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
  public ResponseEntity<GenericResponseDto<Void>> createClub(@Valid @RequestBody ClubSaveDTO dto){
     log.info("POST /clubs - Create club");
     this.clubService.createClub(dto);

     return ResponseEntity.status(HttpStatus.CREATED)
             .body(GenericResponseDto.<Void>builder()
                 .code(HttpStatus.CREATED.value())
                 .message("Club created successfully")
                 .build());
  }
  @GetMapping()
  public ResponseEntity<GenericResponseDto<List<ClubListDTO>>> getAllClubs(@RequestParam(required = false, defaultValue = "") String status){
    log.info("GET /clubs - Get all clubs");
    List<ClubListDTO> clubs = clubService.getAllClubs(status);

    return ResponseEntity.status(HttpStatus.OK)
            .body(GenericResponseDto.<List<ClubListDTO>>builder()
                .code(HttpStatus.OK.value())
                .message("Clubs retrieved successfully")
                .data(clubs)
                .build());
  }
  @GetMapping("/{id}")
  public ResponseEntity<GenericResponseDto<ClubDetailDTO>> getClubById(@PathVariable Long id){
    log.info("GET /clubs/{} - Get club by id", id);
    ClubDetailDTO club = this.clubService.getClubById(id);

    return ResponseEntity.status(HttpStatus.OK)
            .body(GenericResponseDto.<ClubDetailDTO>builder()
                .code(HttpStatus.OK.value())
                .message("Club retrieved successfully")
                .data(club)
                .build());
  }
  @PatchMapping("/{id}")
  public ResponseEntity<GenericResponseDto<Void>> updateClub(@PathVariable Long id,@Valid @RequestBody ClubSaveDTO dto){
    log.info("PATCH /clubs/{} - Update club by id", id);
    this.clubService.updateClub(id, dto);

    return ResponseEntity.status(HttpStatus.OK)
        .body(GenericResponseDto.<Void>builder()
            .code(HttpStatus.OK.value())
            .message("Club updated successfully")
            .build());
  }
  @PatchMapping("/{id}/status")
  public ResponseEntity<GenericResponseDto<Void>> updateClubStatus(@PathVariable Long id, @Valid @RequestBody ClubStatusDto statusDto){
    log.info("PATCH /clubs/{}/status - Update club status by id",id);
    this.clubService.updateClubStatus(id, statusDto);

    return ResponseEntity.status(HttpStatus.OK)
        .body(GenericResponseDto.<Void>builder()
            .code(HttpStatus.OK.value())
            .message("Club status updated successfully")
            .build());
  }
  @DeleteMapping("/{id}")
  public ResponseEntity<GenericResponseDto<Void>> deleteClubById(@PathVariable Long id){
    log.info("DELETE /clubs/{} - Delete club by id", id);
    this.clubService.deleteClubById(id);

    return ResponseEntity.status(HttpStatus.OK)
        .body(GenericResponseDto.<Void>builder()
            .code(HttpStatus.OK.value())
            .message("Club deleted successfully")
            .build());
  }
}