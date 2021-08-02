package kg.easy.salonservice.controllers;

import kg.easy.salonservice.exceptions.NotExistTime;
import kg.easy.salonservice.models.dtos.SalonDto;
import kg.easy.salonservice.services.SalonService;
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
        return null;
    }
}
