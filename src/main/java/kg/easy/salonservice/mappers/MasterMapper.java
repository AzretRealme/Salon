package kg.easy.salonservice.mappers;

import kg.easy.salonservice.models.dtos.MasterDto;
import kg.easy.salonservice.models.enitities.Master;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MasterMapper {
    MasterMapper INSTANCE = Mappers.getMapper(MasterMapper.class);

    Master toMaster(MasterDto masterDto);
    MasterDto toMasterDto(Master master);

    List<Master> toMasterList(List<MasterDto> masterDtoList);
    List<MasterDto> toMasterDtoList(List<Master> masterList);
}
