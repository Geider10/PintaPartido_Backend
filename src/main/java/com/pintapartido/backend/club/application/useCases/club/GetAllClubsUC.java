package com.pintapartido.backend.club.application.useCases.club;

import com.pintapartido.backend.club.application.dtos.response.ClubListDto;
import com.pintapartido.backend.club.application.mappers.ClubMapper;
import com.pintapartido.backend.club.domain.models.ClubModel;
import com.pintapartido.backend.club.domain.respositories.ClubRepository;
import java.util.List;

public class GetAllClubsUC {
  private final ClubRepository clubRepository;
  public GetAllClubsUC(ClubRepository clubRepository){
    this.clubRepository = clubRepository;
  }

  public List<ClubListDto> execute(String status){
    List<ClubModel> clubs = this.clubRepository.findAll();
    if (!status.isBlank() && status.equals("ACTIVE") || status.equals("INACTIVE")){
      clubs = this.clubRepository.findByStatus(status);
    }

    return clubs.stream()
        .map(c -> ClubMapper.convertToClubList(c))
        .toList();
  }
}
