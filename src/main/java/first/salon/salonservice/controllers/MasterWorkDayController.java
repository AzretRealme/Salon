package first.salon.salonservice.controllers;

import first.salon.salonservice.models.dtos.inputs.MasterWorkDayInput;
import first.salon.salonservice.models.dtos.responses.MasterWorkDayAppDto;
import first.salon.salonservice.models.dtos.MasterWorkDayDto;
import first.salon.salonservice.services.MasterWorkDayService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/masterworkday")
public class MasterWorkDayController  implements BaseCrudController<MasterWorkDayDto,Long>{

    private MasterWorkDayService masterWorkDayService;
    @PostMapping("/save-custom")
    public MasterWorkDayDto save(@RequestBody MasterWorkDayInput masterWorkDayInput) {

            return masterWorkDayService.saveCustom(masterWorkDayInput);

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
        return null;
    }

    @Override
    public List<MasterWorkDayDto> findAll() {
        return null;
    }

    @GetMapping("/getByBranch")
    public List<MasterWorkDayAppDto> findAllByBranchIdAndDate(@RequestParam Long branchId, @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date){
        return masterWorkDayService.getByBranchIdAndDate(branchId,date);
    }
}
