package com.pintapartido.backend.club.application.mappers;

import com.pintapartido.backend.club.application.dtos.response.ClubDetailDTO;
import com.pintapartido.backend.club.application.dtos.response.ClubListDTO;
import com.pintapartido.backend.club.application.dtos.request.ClubSaveDTO;
import com.pintapartido.backend.club.domain.models.ClubModel;

public class ClubMapper {
  public static ClubModel convertToModel(ClubSaveDTO dto){
    return new ClubModel(
        dto.getName(),
        dto.getAddress(),
        dto.getLocation()
    );
  }
  public static ClubListDTO convertToClubList(ClubModel club){
    return new ClubListDTO(
        club.getId(),
        club.getAddress(),
        club.getLocation()
    );
  }
  public static ClubDetailDTO convertToClubDetail(ClubModel club){
    return new ClubDetailDTO(
        club.getId(),
        club.getName(),
        club.getAddress(),
        club.getLocation(),
        club.getStatus()
    );
  }
  public static void updateToModel(ClubSaveDTO dto, ClubModel club){
    club.setName(dto.getName());
    club.setAddress(dto.getAddress());
    club.setLocation(dto.getLocation());
  }
}
