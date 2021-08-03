package kg.easy.salonservice.services.impl;

import kg.easy.salonservice.dao.MasterWorkDayRepo;
import kg.easy.salonservice.mappers.MasterWorkDayMapper;
import kg.easy.salonservice.models.dtos.MasterWorkDayAppDto;
import kg.easy.salonservice.models.dtos.MasterWorkDayDto;
import kg.easy.salonservice.models.enitities.MasterWorkDay;
import kg.easy.salonservice.services.MasterWorkDayService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@AllArgsConstructor
public class MasterWorkDayServiceImpl implements MasterWorkDayService {

    private MasterWorkDayRepo masterWorkDayRepo;

    @Override
    public MasterWorkDayDto save(MasterWorkDayDto masterWorkDayDto) {
        MasterWorkDay masterWorkDay = MasterWorkDayMapper.INSTANCE.toMasterWorkDay(masterWorkDayDto);
        masterWorkDay = masterWorkDayRepo.save(masterWorkDay);
        return MasterWorkDayMapper.INSTANCE.toMasterWorkDayDto(masterWorkDay);
    }

    @Override
    public MasterWorkDayDto update(MasterWorkDayDto masterWorkDayDto) {
        return null;
    }

    @Override
    public MasterWorkDayDto findById(Long id) {
        return null;
    }

    @Override
    public List<MasterWorkDayDto> findAll() {
        return null;
    }

    @Override
    public List<MasterWorkDayAppDto> getByBranchIdAndDate(Long branchId, LocalDate textDate) {

        List<MasterWorkDay> masterWorkDayList = masterWorkDayRepo.findAllByBranchIdAndWorkDayIs(branchId,textDate);
        List<MasterWorkDayAppDto> masterWorkDayAppDtoList = MasterWorkDayMapper.INSTANCE.toMasterWorkDayAppDto(masterWorkDayList);
        return masterWorkDayAppDtoList;
    }

    @Override
    public boolean inTime(Long id, LocalDateTime startTime, LocalDateTime endTime) {
        return masterWorkDayRepo.existsByIdAndStartTimeIsLessThanEqualAndEndTimeGreaterThanEqual(id,startTime,endTime);
    }
}
