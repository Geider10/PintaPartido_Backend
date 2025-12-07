package com.pintapartido.backend.club.application.useCases.club;

import com.pintapartido.backend.club.application.dtos.request.ClubUpdateDto;
import com.pintapartido.backend.club.application.mappers.ClubMapper;
import com.pintapartido.backend.shared.exceptions.category.ConflictException;
import com.pintapartido.backend.shared.exceptions.category.NotFoundException;
import com.pintapartido.backend.club.domain.models.ClubModel;
import com.pintapartido.backend.club.domain.respositories.ClubRepository;
import java.util.Optional;

public class UpdateClubByIdUC {
  private final ClubRepository clubRepository;
  public UpdateClubByIdUC(ClubRepository clubRepository){
    this.clubRepository = clubRepository;
  }

  /**
   * Update a club by id.<p>
   *
   * Business rules:<p>
   * - Club must exist within the system.<p>
   * - Club name and address must be uniques within the system.<p>
   *
   * Throws:<p>
   * NotFoundException if club not found.<p>
   * ConflictException if club name and address already exists.
   * @param id the club id, not null
   * @param dto the club data. not null
   */
  public void execute(Long id, ClubUpdateDto dto){
    Optional<ClubModel> club = this.clubRepository.findById(id);
    if(club.isEmpty()) throw new NotFoundException("Club not found by id");

    boolean existsClub = this.clubRepository.existsByNameAndAddressAndIdNot(dto.getName(), dto.getAddress(),id);
    if(existsClub) throw new ConflictException("Club name and address already exists");

    ClubMapper.updateToModel(dto, club.get());
    this.clubRepository.save(club.get());
  }
}
