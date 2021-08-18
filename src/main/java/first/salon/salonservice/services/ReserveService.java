package first.salon.salonservice.services;

import first.salon.salonservice.models.dtos.ReservedHourDto;
import first.salon.salonservice.models.dtos.inputs.ReservedHourInput;
import first.salon.salonservice.models.dtos.responses.ReservedHourDtoResponse;
import first.salon.salonservice.models.dtos.responses.ReservedHourWithMasterName;

import java.util.List;

public interface ReserveService extends BaseCrudService<ReservedHourDto,Long> {
    List<ReservedHourDto> findByMasterWorkDayId(Long masterWorkDayId);
    public List<ReservedHourDtoResponse> findAllReservedHoursByMasterDayId(Long masterWorkDayId);

    public ReservedHourWithMasterName saveCustom(ReservedHourInput reservedHourDto);
}
