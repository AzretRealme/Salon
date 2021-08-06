package kg.easy.salonservice.services;

import kg.easy.salonservice.models.dtos.ReservedHourDto;
import kg.easy.salonservice.models.dtos.inputs.ReservedHourInput;
import kg.easy.salonservice.models.dtos.responses.ReservedHourDtoResponse;
import kg.easy.salonservice.models.dtos.responses.ReservedHourWithMasterName;

import java.util.List;

public interface ReserveService extends BaseCrudService<ReservedHourDto,Long> {
    List<ReservedHourDto> findByMasterWorkDayId(Long masterWorkDayId);
    public List<ReservedHourDtoResponse> findAllReservedHoursByMasterDayId(Long masterWorkDayId);

    public ReservedHourWithMasterName saveCustom(ReservedHourInput reservedHourDto);
}
