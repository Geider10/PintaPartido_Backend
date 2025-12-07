package com.pintapartido.backend.club.application.services;

import com.pintapartido.backend.club.application.dtos.request.ClubUpdateDto;
import com.pintapartido.backend.club.application.dtos.response.ClubDetailDto;
import com.pintapartido.backend.club.application.dtos.response.ClubListDto;
import com.pintapartido.backend.club.application.dtos.request.ClubSaveDto;
import com.pintapartido.backend.club.application.useCases.club.DeleteClubByIdUC;
import com.pintapartido.backend.club.application.useCases.club.GetAllClubsUC;
import com.pintapartido.backend.club.application.useCases.club.GetClubByIdUC;
import com.pintapartido.backend.club.application.useCases.club.CreateClubUC;
import com.pintapartido.backend.club.application.useCases.club.UpdateClubByIdUC;
import com.pintapartido.backend.club.domain.respositories.ClubRepository;
import java.util.List;

public class ClubService {
  private final CreateClubUC createClubUC;
  private final GetAllClubsUC getAllClubsUC;
  private final GetClubByIdUC getClubByIdUC;
  private final UpdateClubByIdUC updateClubByIdUC;
  private final DeleteClubByIdUC deleteClubByIdUC;

  public ClubService(ClubRepository clubRepository){
    this.createClubUC = new CreateClubUC(clubRepository);
    this.getAllClubsUC = new GetAllClubsUC(clubRepository);
    this.getClubByIdUC = new GetClubByIdUC(clubRepository);
    this.updateClubByIdUC = new UpdateClubByIdUC(clubRepository);
    this.deleteClubByIdUC = new DeleteClubByIdUC(clubRepository);
  }

  public void createClub(ClubSaveDto dto){
    this.createClubUC.execute(dto);
  }
  public ClubDetailDto getClubById(Long id){
    return this.getClubByIdUC.execute(id);
  }
  public List<ClubListDto> getAllClubs(){
    return this.getAllClubsUC.execute();
  }
  public void updateClub(Long id, ClubUpdateDto dto) {
    this.updateClubByIdUC.execute(id, dto);
  }
  public void deleteClubById(Long id){
    this.deleteClubByIdUC.execute(id);
  }
}
