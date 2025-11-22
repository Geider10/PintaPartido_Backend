package com.pintapartido.backend.club.application.useCases;

import com.pintapartido.backend.shared.exceptions.NotFoundException;
import com.pintapartido.backend.club.domain.models.ClubModel;
import com.pintapartido.backend.club.domain.respositories.ClubRepository;
import java.util.Optional;

public class DeleteClubByIdUseCase {
  public final ClubRepository clubRepository;
  public DeleteClubByIdUseCase(ClubRepository clubRepository){
    this.clubRepository = clubRepository;
  }

  public void execute(Long id){
    Optional<ClubModel> club = this.clubRepository.findById(id);
    if (club.isEmpty()) throw new NotFoundException("Club cannot be get by ID because was not found.");

    this.clubRepository.deleteById(id);
  }
}
