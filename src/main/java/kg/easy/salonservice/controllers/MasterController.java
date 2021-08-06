package kg.easy.salonservice.controllers;

import kg.easy.salonservice.exceptions.NotExistTime;
import kg.easy.salonservice.models.dtos.MasterDto;
import kg.easy.salonservice.services.MasterService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/master")
public class MasterController implements BaseCrudController<MasterDto,Long>{


    private MasterService masterService;
    @Override
    public MasterDto save(MasterDto masterDto) {

            return masterService.save(masterDto);

    }

    @Override
    public MasterDto update(MasterDto masterDto) {
        return null;
    }

    @Override
    public MasterDto findById(Long id) {
        return null;
    }

    @Override
    public List<MasterDto> findAll() {
        return masterService.findAll();
    }
}