package kg.easy.salonservice.controllers;

import kg.easy.salonservice.models.dtos.ReservedHourDto;
import kg.easy.salonservice.services.ReserveService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/reserve")
@RestController
@AllArgsConstructor
public class ReservedHourController implements BaseCrudController<ReservedHourDto, Long> {


    private ReserveService reserveService;

    @Override
    public ReservedHourDto save(ReservedHourDto reservedHourDto) {
        return reserveService.save(reservedHourDto);
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
    public List<ReservedHourDto> get(@RequestParam Long id){
        return reserveService.findByMasterWorkDayId(id);
    }
}
