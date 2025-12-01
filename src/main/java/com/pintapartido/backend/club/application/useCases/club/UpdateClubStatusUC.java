package com.pintapartido.backend.club.application.useCases.club;

import com.pintapartido.backend.club.application.dtos.request.ClubStatusDto;
import com.pintapartido.backend.club.domain.models.ClubModel;
import com.pintapartido.backend.club.domain.respositories.ClubRepository;
import com.pintapartido.backend.shared.exceptions.category.NotFoundException;
import java.util.Optional;

public class UpdateClubStatusUC {

  private final ClubRepository clubRepository;
  public UpdateClubStatusUC(ClubRepository clubRepository){ this.clubRepository = clubRepository;}

  /**
   * Update club status by id.<p>
   *
   * Business rules:<p>
   * - Club must exist within the system.<p>
   *
   * Throws:<p>
   * - NotFoundException if club not found.
   * @param id the club id, not null
   * @param statusDto the club status, not null
   */
  public void execute(Long id, ClubStatusDto statusDto){
    Optional<ClubModel> club = this.clubRepository.findById(id);
    if(club.isEmpty()) throw new NotFoundException("Club not found by id");

    club.get().setStatus(statusDto.getStatus());
    this.clubRepository.save(club.get());
  }
}
