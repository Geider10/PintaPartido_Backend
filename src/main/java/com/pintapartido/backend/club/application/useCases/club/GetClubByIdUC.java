package com.pintapartido.backend.club.application.useCases.club;

import com.pintapartido.backend.club.application.dtos.response.ClubDetailDto;
import com.pintapartido.backend.club.application.mappers.ClubMapper;
import com.pintapartido.backend.shared.exceptions.category.NotFoundException;
import com.pintapartido.backend.club.domain.models.ClubModel;
import com.pintapartido.backend.club.domain.respositories.ClubRepository;
import java.util.Optional;

public class GetClubByIdUC {
  public final ClubRepository clubRepository;
  public GetClubByIdUC(ClubRepository clubRepository){
    this.clubRepository = clubRepository;
  }

  public ClubDetailDto execute(Long id){
    Optional<ClubModel> club = this.clubRepository.findById(id);
    if(club.isEmpty()) throw new NotFoundException("Club not found by id");

    return ClubMapper.convertToClubDetail(club.get());
  }
}
