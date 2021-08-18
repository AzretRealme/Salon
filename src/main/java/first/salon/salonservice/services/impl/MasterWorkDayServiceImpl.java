package first.salon.salonservice.services.impl;

import first.salon.salonservice.dao.MasterWorkDayRepo;
import first.salon.salonservice.mappers.MasterWorkDayMapper;
import first.salon.salonservice.models.dtos.BranchDto;
import first.salon.salonservice.models.dtos.MasterDto;
import first.salon.salonservice.models.dtos.inputs.MasterWorkDayInput;
import first.salon.salonservice.models.dtos.responses.MasterWorkDayAppDto;
import first.salon.salonservice.models.dtos.MasterWorkDayDto;
import first.salon.salonservice.models.enitities.MasterWorkDay;
import first.salon.salonservice.services.BranchService;
import first.salon.salonservice.services.MasterService;
import first.salon.salonservice.services.MasterWorkDayService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class MasterWorkDayServiceImpl implements MasterWorkDayService {

    private MasterWorkDayRepo masterWorkDayRepo;
    private MasterService masterService;
    private BranchService branchService;


    public MasterWorkDayDto saveCustom(MasterWorkDayInput masterWorkDayInput) {
        MasterWorkDayDto masterWorkDayDto = MasterWorkDayMapper.INSTANCE.toMasterWorkDayDtoByInput(masterWorkDayInput);
        MasterDto masterDto = masterService.save(masterService.findById(masterWorkDayInput.getMasterId()));
        BranchDto branchDto = branchService.save(branchService.findById(masterWorkDayInput.getBranchId()));
        masterWorkDayDto.setMaster(masterDto);
        masterWorkDayDto.setBranch(branchDto);
        System.out.println("salon " + branchDto.getSalonDto());
        MasterWorkDay entity = MasterWorkDayMapper.INSTANCE.toMasterWorkDay(masterWorkDayDto);
        MasterWorkDay masterWorkDaySaved = masterWorkDayRepo.save(entity);
        MasterWorkDayDto masterWorkDayDtoSaved = MasterWorkDayMapper.INSTANCE.toMasterWorkDayDto(masterWorkDaySaved);
        return masterWorkDayDtoSaved;
    }

    @Override
    public MasterWorkDayDto save(MasterWorkDayDto masterWorkDayDto) {
        return null;
    }

    @Override
    public MasterWorkDayDto update(MasterWorkDayDto masterWorkDayDto) {
        return null;
    }

    @Override
    public MasterWorkDayDto findById(Long id) {
        return MasterWorkDayMapper.INSTANCE.toMasterWorkDayDto(masterWorkDayRepo.findById(id).orElseThrow(() -> new RuntimeException("Work day not found!!!")));
    }

    @Override
    public List<MasterWorkDayDto> findAll() {
        return null;
    }

    @Override
    public List<MasterWorkDayAppDto> getByBranchIdAndDate(Long branchId, LocalDate textDate) {

        List<MasterWorkDayDto> masterWorkDayList = MasterWorkDayMapper.INSTANCE.toMasterWorkDayDtoList(masterWorkDayRepo.findAllByBranchIdAndWorkDayIs(branchId,textDate));
        return MasterWorkDayMapper.INSTANCE.toMasterWorkDayAppDto(masterWorkDayList);
    }

    @Override
    public boolean inTime(Long id, LocalDateTime startTime, LocalDateTime endTime) {
        return masterWorkDayRepo.existsByIdAndStartTimeIsLessThanEqualAndEndTimeGreaterThanEqual(id,startTime,endTime);
    }


}