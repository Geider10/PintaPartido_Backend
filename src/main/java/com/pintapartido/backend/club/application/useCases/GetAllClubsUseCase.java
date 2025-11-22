package com.pintapartido.backend.club.application.useCases;

import com.pintapartido.backend.club.application.dtos.ClubListDTO;
import com.pintapartido.backend.club.application.mappers.ClubMapper;
import com.pintapartido.backend.club.domain.models.ClubModel;
import com.pintapartido.backend.club.domain.respositories.ClubRepository;
import java.util.List;

public class GetAllClubsUseCase {
  private final ClubRepository clubRepository;
  public GetAllClubsUseCase(ClubRepository clubRepository){
    this.clubRepository = clubRepository;
  }

  public List<ClubListDTO> execute(String status){
    List<ClubModel> clubs = this.clubRepository.findAll();
    if (!status.isBlank() && status.equals("ACTIVE") || status.equals("INACTIVE")){
      clubs = this.clubRepository.findByStatus(status);
    }

    return clubs.stream()
        .map(c -> ClubMapper.convertToClubList(c))
        .toList();
  }
}
