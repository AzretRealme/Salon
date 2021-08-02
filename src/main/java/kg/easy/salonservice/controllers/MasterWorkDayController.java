package kg.easy.salonservice.controllers;

import kg.easy.salonservice.exceptions.NotExistTime;
import kg.easy.salonservice.models.dtos.MasterWorkDayAppDto;
import kg.easy.salonservice.models.dtos.MasterWorkDayDto;
import kg.easy.salonservice.services.MasterWorkDayService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/masterworkday")
public class MasterWorkDayController  implements BaseCrudController<MasterWorkDayDto,Long>{

    private MasterWorkDayService masterWorkDayService;
    @Override
    public MasterWorkDayDto save(MasterWorkDayDto masterWorkDayDto) {

            return masterWorkDayService.save(masterWorkDayDto);

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
