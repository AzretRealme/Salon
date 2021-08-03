package kg.easy.salonservice.services;

import kg.easy.salonservice.models.dtos.ReservedHourDto;

import java.util.List;

public interface ReserveService extends BaseCrudService<ReservedHourDto,Long> {
    List<ReservedHourDto> findByMasterWorkDayId(Long masterWorkDayId);
}
