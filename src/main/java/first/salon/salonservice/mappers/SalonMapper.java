package first.salon.salonservice.mappers;

import first.salon.salonservice.models.dtos.SalonDto;
import first.salon.salonservice.models.enitities.Salon;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SalonMapper{

    SalonMapper INSTANCE = Mappers.getMapper(SalonMapper.class);

    default SalonDto toSalonDto(Salon salon) {
        SalonDto salonDto = new SalonDto();
        salonDto.setId(salon.getId());
        salonDto.setActive(salon.isActive());
        salonDto.setName(salon.getName());
        return salonDto;
    }

    default Salon toSalon(SalonDto salonDto) {
        Salon salon = new Salon();
        salon.setId(salonDto.getId());
        salon.setActive(salonDto.isActive());
        salon.setName(salonDto.getName());
        return salon;
    }

    List<Salon> toSalonList(List<SalonDto> salonDtoList);

    List<SalonDto> toSalonDtoList(List<Salon> salonList);
}
