package com.pintapartido.backend.club.application.useCases.club;

import com.pintapartido.backend.shared.exceptions.category.NotFoundException;
import com.pintapartido.backend.club.domain.models.ClubModel;
import com.pintapartido.backend.club.domain.respositories.ClubRepository;
import java.util.Optional;

public class DeleteClubByIdUC {
  public final ClubRepository clubRepository;
  public DeleteClubByIdUC(ClubRepository clubRepository){
    this.clubRepository = clubRepository;
  }

  public void execute(Long id){
    Optional<ClubModel> club = this.clubRepository.findById(id);
    if (club.isEmpty()) throw new NotFoundException("Club not found by id");

    this.clubRepository.deleteById(id);
  }
}
