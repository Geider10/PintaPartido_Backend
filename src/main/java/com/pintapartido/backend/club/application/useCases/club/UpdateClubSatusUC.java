package com.pintapartido.backend.club.application.useCases.club;

import com.pintapartido.backend.club.application.dtos.request.ClubStatusDto;
import com.pintapartido.backend.club.domain.models.ClubModel;
import com.pintapartido.backend.club.domain.respositories.ClubRepository;
import com.pintapartido.backend.shared.exceptions.category.NotFoundException;
import java.util.Optional;

public class UpdateClubSatusUC {

  private final ClubRepository clubRepository;
  public UpdateClubSatusUC (ClubRepository clubRepository){ this.clubRepository = clubRepository;}

  public void execute(Long id, ClubStatusDto statusDto){
    Optional<ClubModel> club = this.clubRepository.findById(id);
    if(club.isEmpty()) throw new NotFoundException("Club not found by id");

    club.get().setStatus(statusDto.getStatus());
    this.clubRepository.save(club.get());
  }
}
