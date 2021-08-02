package kg.easy.salonservice.services;

import kg.easy.salonservice.models.dtos.MasterWorkDayAppDto;
import kg.easy.salonservice.models.dtos.MasterWorkDayDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface MasterWorkDayService extends BaseCrudService<MasterWorkDayDto,Long> {
    List<MasterWorkDayAppDto> getByBranchIdAndDate(Long branchId, LocalDate date);

    boolean inTime(Long id, LocalDateTime startTime, LocalDateTime endTime);
}
