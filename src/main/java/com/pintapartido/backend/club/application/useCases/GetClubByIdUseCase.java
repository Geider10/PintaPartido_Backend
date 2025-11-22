package com.pintapartido.backend.club.application.useCases;

import com.pintapartido.backend.club.application.dtos.ClubDetailDTO;
import com.pintapartido.backend.club.application.mappers.ClubMapper;
import com.pintapartido.backend.shared.exceptions.NotFoundException;
import com.pintapartido.backend.club.domain.models.ClubModel;
import com.pintapartido.backend.club.domain.respositories.ClubRepository;
import java.util.Optional;

public class GetClubByIdUseCase {
  public final ClubRepository clubRepository;
  public GetClubByIdUseCase(ClubRepository clubRepository){
    this.clubRepository = clubRepository;
  }

  public ClubDetailDTO execute(Long id){
    Optional<ClubModel> club = this.clubRepository.findById(id);
    if(club.isEmpty()) throw new NotFoundException("Club cannot be get by ID because was not found.");

    return ClubMapper.convertToClubDetail(club.get());
  }
}
