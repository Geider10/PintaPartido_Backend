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

  /**
   * Get all clubs.
   * @return clubs of list.
   */
  public List<ClubListDto> execute(){
    List<ClubModel> clubs = this.clubRepository.findAll();

    return clubs.stream()
        .map(c -> ClubMapper.convertToClubList(c))
        .toList();
  }
}
