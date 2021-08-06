package kg.easy.salonservice.controllers;

import kg.easy.salonservice.models.dtos.ReservedHourDto;
import kg.easy.salonservice.models.dtos.inputs.ReservedHourInput;
import kg.easy.salonservice.models.dtos.responses.ReservedHourDtoResponse;
import kg.easy.salonservice.models.dtos.responses.ReservedHourWithMasterName;
import kg.easy.salonservice.services.ReserveService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/reserve")
@RestController
@AllArgsConstructor
public class ReservedHourController implements BaseCrudController<ReservedHourDto, Long> {


    private ReserveService reserveService;

    @PostMapping("/save-by-input")
    public ReservedHourWithMasterName saveCustom(@RequestBody ReservedHourInput reservedHourDto) {
        return reserveService.saveCustom(reservedHourDto);
    }

    @Override
    public ReservedHourDto save(ReservedHourDto reservedHourDto) {
        return null;
    }

    @Override
    public ReservedHourDto update(ReservedHourDto reservedHourDto) {
        return null;
    }

    @Override
    public ReservedHourDto findById(Long id) {
        return null;
    }

    @Override
    public List<ReservedHourDto> findAll() {
        return null;
    }

    @GetMapping("/getId")
    public List<ReservedHourDto> get(@RequestParam Long masterWorkDayId){
        return reserveService.findByMasterWorkDayId(masterWorkDayId);
    }

    @GetMapping("/find-reserved-hours-by-day")
    List<ReservedHourDtoResponse> getAllReservedHoursByMasterId(@RequestParam Long masterWorkDayId){
        return reserveService.findAllReservedHoursByMasterDayId(masterWorkDayId);
    }

}
