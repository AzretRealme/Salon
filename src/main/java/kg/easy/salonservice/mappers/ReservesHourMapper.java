package kg.easy.salonservice.mappers;

import kg.easy.salonservice.models.dtos.ReservedHourDto;
import kg.easy.salonservice.models.enitities.ReservedHours;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ReservesHourMapper {

    ReservesHourMapper INSTANCE = Mappers.getMapper(ReservesHourMapper.class);

    ReservedHours toReservedHours(ReservedHourDto reservedHourDto);
    ReservedHourDto toReservedHoursDto(ReservedHours reservedHours);

    List<ReservedHourDto> toReservedHourDtoList(List<ReservedHours> reservedHoursList);

    List<ReservedHours> toReservedHoursList(List<ReservedHourDto> reservedHourDtoList);

}

