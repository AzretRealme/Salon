package kg.easy.salonservice.controllers;

import kg.easy.salonservice.exceptions.NotExistTime;
import kg.easy.salonservice.models.dtos.SalonDto;
import kg.easy.salonservice.services.SalonService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @PostMapping("/saveResponseEntity")
    public ResponseEntity<?> saveSalon(@RequestBody SalonDto salonDto) throws NotExistTime {
        try {
            return salonService.saveNewMethodByResponseEntity(salonDto);
        } catch (NotExistTime notExistTime) {
            throw  new NotExistTime("049");
        }
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
