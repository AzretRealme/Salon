package first.salon.salonservice.mappers;

import first.salon.salonservice.models.dtos.inputs.MasterWorkDayInput;
import first.salon.salonservice.models.dtos.responses.MasterWorkDayAppDto;
import first.salon.salonservice.models.dtos.MasterWorkDayDto;
import first.salon.salonservice.models.enitities.MasterWorkDay;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface MasterWorkDayMapper{

    MasterWorkDayMapper INSTANCE = Mappers.getMapper(MasterWorkDayMapper.class);

    default MasterWorkDay toMasterWorkDay(MasterWorkDayDto masterWorkDayDto) {
        MasterWorkDay masterWorkDay = new MasterWorkDay();
        masterWorkDay.setMaster(MasterMapper.INSTANCE.toMaster(masterWorkDayDto.getMaster()));
        masterWorkDay.setWorkDay(masterWorkDayDto.getWorkDay());
        masterWorkDay.setBranch(BranchMapper.INTANCE.toBranch(masterWorkDayDto.getBranch()));
        masterWorkDay.setId(masterWorkDayDto.getId());
        masterWorkDay.setStartTime(masterWorkDayDto.getStartTime());
        masterWorkDay.setEndTime(masterWorkDayDto.getEndTime());
        masterWorkDay.setAddDate(masterWorkDayDto.getAddDate());
        masterWorkDay.setEditDate(masterWorkDayDto.getEditDate());
        return masterWorkDay;
    }

    default MasterWorkDayDto toMasterWorkDayDto(MasterWorkDay masterWorkDay) {
        MasterWorkDayDto masterWorkDayDto = new MasterWorkDayDto();
        masterWorkDayDto.setMaster(MasterMapper.INSTANCE.toMasterDto(masterWorkDay.getMaster()));
        masterWorkDayDto.setWorkDay(masterWorkDay.getWorkDay());
        masterWorkDayDto.setBranch(BranchMapper.INTANCE.toBranchDto(masterWorkDay.getBranch()));
        masterWorkDayDto.setId(masterWorkDay.getId());
        masterWorkDayDto.setStartTime(masterWorkDay.getStartTime());
        masterWorkDayDto.setEndTime(masterWorkDay.getEndTime());
        masterWorkDayDto.setAddDate(masterWorkDay.getAddDate());
        masterWorkDayDto.setEditDate(masterWorkDay.getEditDate());
        return masterWorkDayDto;
    }

    List<MasterWorkDay> toMasterWorkDayList(List<MasterWorkDayDto> masterWorkDayDtoList);

    List<MasterWorkDayDto> toMasterWorkDayDtoList(List<MasterWorkDay> masterWorkDayList);

    default MasterWorkDayDto toMasterWorkDayDtoByInput(MasterWorkDayInput masterWorkDayInput) {
        MasterWorkDayDto masterWorkDayDto = new MasterWorkDayDto();
        masterWorkDayDto.setWorkDay(masterWorkDayInput.getWorkDay());
        masterWorkDayDto.setId(masterWorkDayInput.getId());
        masterWorkDayDto.setStartTime(masterWorkDayInput.getStartTime());
        masterWorkDayDto.setEndTime(masterWorkDayInput.getEndTime());
        return masterWorkDayDto;
    }

    default List<MasterWorkDayAppDto> toMasterWorkDayAppDto(List<MasterWorkDayDto> masterWorkDayList){

        List<MasterWorkDayAppDto> masterWorkDayAppDtoList = new ArrayList<>();
        for (MasterWorkDayDto m:masterWorkDayList){
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
