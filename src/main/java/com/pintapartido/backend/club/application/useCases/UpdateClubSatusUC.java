package com.pintapartido.backend.club.application.useCases;

import com.pintapartido.backend.club.application.dtos.ClubStatusDto;
import com.pintapartido.backend.club.domain.exceptions.InvalidateStatusException;
import com.pintapartido.backend.club.domain.models.ClubModel;
import com.pintapartido.backend.club.domain.respositories.ClubRepository;
import com.pintapartido.backend.shared.exceptions.NotFoundException;
import java.util.Optional;

public class UpdateClubSatusUC {

  private final ClubRepository clubRepository;
  public UpdateClubSatusUC (ClubRepository clubRepository){ this.clubRepository = clubRepository;}

  public void execute(Long id, ClubStatusDto statusDto){
    Optional<ClubModel> club = this.clubRepository.findById(id);
    if(club.isEmpty()) throw new NotFoundException("Club cannot be get by ID because was not found.");
    if(!statusDto.getStatus().equals("ACTIVE") && !statusDto.getStatus().equals("INACTIVE"))  throw new InvalidateStatusException();

    club.get().setStatus(statusDto.getStatus());
    this.clubRepository.save(club.get());
  }

}
