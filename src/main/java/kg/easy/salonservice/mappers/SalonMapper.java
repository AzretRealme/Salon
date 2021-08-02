package kg.easy.salonservice.mappers;

import kg.easy.salonservice.models.dtos.SalonDto;
import kg.easy.salonservice.models.enitities.Salon;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SalonMapper{

    SalonMapper INSTANCE = Mappers.getMapper(SalonMapper.class);

    SalonDto toSalonDto(Salon salon);

    Salon toSalon(SalonDto salonDto);

    List<Salon> toSalonList(List<SalonDto> salonDtoList);

    List<SalonDto> toSalonDtoList(List<Salon> salonList);


}
