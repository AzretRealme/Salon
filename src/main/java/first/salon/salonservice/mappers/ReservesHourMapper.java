package first.salon.salonservice.mappers;

import first.salon.salonservice.models.dtos.ReservedHourDto;
import first.salon.salonservice.models.dtos.responses.ReservedHourDtoResponse;
import first.salon.salonservice.models.enitities.ReservedHours;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface ReservesHourMapper {

    ReservesHourMapper INSTANCE = Mappers.getMapper(ReservesHourMapper.class);

    default ReservedHours toReservedHours(ReservedHourDto reservedHourDto) {
        ReservedHours reservedHours = new ReservedHours();
        reservedHours.setClient(ClientMapper.INSTANCE.toClient(reservedHourDto.getClient()));
        reservedHours.setEndTime(reservedHourDto.getEndTime());
        reservedHours.setStartTime(reservedHourDto.getStartTime());
        reservedHours.setId(reservedHourDto.getId());
        reservedHours.setReserveStatus(reservedHourDto.getReserveStatus());
        reservedHours.setMasterWorkDay(MasterWorkDayMapper.INSTANCE.toMasterWorkDay(reservedHourDto.getMasterWorkDay()));
        return reservedHours;
    }

    default ReservedHourDto toReservedHoursDto(ReservedHours reservedHours) {
        ReservedHourDto reservedHourDto = new ReservedHourDto();
        reservedHourDto.setClient(ClientMapper.INSTANCE.toClientDto(reservedHours.getClient()));
        reservedHourDto.setEndTime(reservedHours.getEndTime());
        reservedHourDto.setStartTime(reservedHours.getStartTime());
        reservedHourDto.setId(reservedHours.getId());
        reservedHourDto.setReserveStatus(reservedHours.getReserveStatus());
        reservedHourDto.setMasterWorkDay(MasterWorkDayMapper.INSTANCE.toMasterWorkDayDto(reservedHours.getMasterWorkDay()));
        return reservedHourDto;
    }

    List<ReservedHourDto> toReservedHourDtoList(List<ReservedHours> reservedHoursList);

    List<ReservedHours> toReservedHoursList(List<ReservedHourDto> reservedHourDtoList);

    default List<ReservedHourDtoResponse> toReservedHourDtoResponse(List<ReservedHourDto> all) {

        return all.stream().map(x -> {
            ReservedHourDtoResponse reservedHourDtoResponse = new ReservedHourDtoResponse();
            reservedHourDtoResponse.setStartTime(x.getStartTime());
            reservedHourDtoResponse.setEndTime(x.getEndTime());
            return reservedHourDtoResponse;
        }).collect(Collectors.toList());
    }
}

