package first.salon.salonservice.controllers;

import first.salon.salonservice.models.dtos.SalonDto;
import first.salon.salonservice.services.SalonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/salon")
@AllArgsConstructor
public class SalonController  implements BaseCrudController<SalonDto,Long>{

    private SalonService salonService;

    @Override
    public SalonDto save(SalonDto salonDto) {

            return salonService.save(salonDto);
    }

    @Override
    public SalonDto update(SalonDto salonDto) {
        return null;
    }

    @Override
    public SalonDto findById(Long id) {
        return null;
    }

    @Override
    public List<SalonDto> findAll() {
        return salonService.findAll();
    }
}
