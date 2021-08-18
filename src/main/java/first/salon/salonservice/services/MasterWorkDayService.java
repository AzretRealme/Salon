package first.salon.salonservice.services;

import first.salon.salonservice.models.dtos.inputs.MasterWorkDayInput;
import first.salon.salonservice.models.dtos.responses.MasterWorkDayAppDto;
import first.salon.salonservice.models.dtos.MasterWorkDayDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface MasterWorkDayService extends BaseCrudService<MasterWorkDayDto,Long> {
    List<MasterWorkDayAppDto> getByBranchIdAndDate(Long branchId, LocalDate date);

    boolean inTime(Long id, LocalDateTime startTime, LocalDateTime endTime);

    MasterWorkDayDto saveCustom(MasterWorkDayInput masterWorkDayInput);
}
