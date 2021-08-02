package kg.easy.salonservice.mappers;

import kg.easy.salonservice.models.dtos.MasterWorkDayAppDto;
import kg.easy.salonservice.models.dtos.MasterWorkDayDto;
import kg.easy.salonservice.models.enitities.MasterWorkDay;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface MasterWorkDayMapper{

    MasterWorkDayMapper INSTANCE = Mappers.getMapper(MasterWorkDayMapper.class);

    MasterWorkDay toMasterWorkDay(MasterWorkDayDto masterWorkDayDto);

    MasterWorkDayDto toMasterWorkDayDto(MasterWorkDay masterWorkDay);

    List<MasterWorkDay> toMasterWorkDayList(List<MasterWorkDayDto> masterWorkDayDtoList);

    List<MasterWorkDayDto> toMasterWorkDayDtoList(List<MasterWorkDay> masterWorkDayList);

    default List<MasterWorkDayAppDto> toMasterWorkDayAppDto(List<MasterWorkDay> masterWorkDayList){

        List<MasterWorkDayAppDto> masterWorkDayAppDtoList = new ArrayList<>();
        for (MasterWorkDay m:masterWorkDayList){
            MasterWorkDayAppDto masterWorkDayAppDto = new MasterWorkDayAppDto();
            masterWorkDayAppDto.setMasterWorkDayId(m.getId());
            masterWorkDayAppDto.setMasterName(m.getMaster().getName());
            masterWorkDayAppDto.setStartTime(m.getStartTime());
            masterWorkDayAppDto.setEndTime(m.getEndTime());
            masterWorkDayAppDto.setWorkDay(m.getWorkDay());
            masterWorkDayAppDtoList.add(masterWorkDayAppDto);
        }
        return masterWorkDayAppDtoList;
    }
}
