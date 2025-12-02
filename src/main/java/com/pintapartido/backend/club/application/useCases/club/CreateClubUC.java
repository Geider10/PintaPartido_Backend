package com.pintapartido.backend.club.application.useCases.club;

import com.pintapartido.backend.club.application.dtos.request.ClubSaveDto;
import com.pintapartido.backend.club.application.mappers.ClubMapper;
import com.pintapartido.backend.club.domain.models.ClubModel;
import com.pintapartido.backend.club.domain.respositories.ClubRepository;
import com.pintapartido.backend.shared.exceptions.category.ConflictException;

public class CreateClubUC {
  private final ClubRepository clubRepository;
  public CreateClubUC(ClubRepository clubRepository){
    this.clubRepository = clubRepository;
  }

  /**
   * Creates a new club.<p>
   *
   * Business rules:<p>
   * - Club name and address must be uniques within the system.<p>
   *
   * Throws:<p>
   * - ConflictException if club name and address already exists.
   * @param dto the club data, not null
   */
  public void execute(ClubSaveDto dto){
    boolean existsClub = this.clubRepository.existsByNameAndAddress(dto.getName(), dto.getAddress());
    if (existsClub) throw new ConflictException("Club name and address already exists");

    ClubModel club = ClubMapper.convertToModel(dto);
    this.clubRepository.save(club);
  }
}
