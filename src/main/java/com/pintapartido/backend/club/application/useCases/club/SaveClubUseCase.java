package com.pintapartido.backend.club.application.useCases.club;

import com.pintapartido.backend.club.application.dtos.request.ClubSaveDTO;
import com.pintapartido.backend.club.application.mappers.ClubMapper;
import com.pintapartido.backend.club.domain.exceptions.DuplicateNameAndAddressException;
import com.pintapartido.backend.club.domain.models.ClubModel;
import com.pintapartido.backend.club.domain.respositories.ClubRepository;

public class SaveClubUseCase {
  private final ClubRepository clubRepository;
  public SaveClubUseCase(ClubRepository clubRepository){
    this.clubRepository = clubRepository;
  }

  public void execute(ClubSaveDTO dto){
    boolean existsClub = this.clubRepository.existsByNameAndAddress(dto.getName(), dto.getAddress());
    if (existsClub) throw new DuplicateNameAndAddressException();

    ClubModel club = ClubMapper.convertToModel(dto);
    this.clubRepository.save(club);
  }
}
