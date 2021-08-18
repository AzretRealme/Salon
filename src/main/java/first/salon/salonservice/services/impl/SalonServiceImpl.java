package first.salon.salonservice.services.impl;

import first.salon.salonservice.dao.SalonRepo;
import first.salon.salonservice.mappers.SalonMapper;
import first.salon.salonservice.models.dtos.SalonDto;
import first.salon.salonservice.models.enitities.Salon;
import first.salon.salonservice.services.SalonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SalonServiceImpl implements SalonService {

    private SalonRepo salonRepo;

    @Override
    public SalonDto save(SalonDto salonDto) {
        Salon salon = SalonMapper.INSTANCE.toSalon(salonDto);
        salon = salonRepo.save(salon);
        return SalonMapper.INSTANCE.toSalonDto(salon);
    }

    @Override
    public SalonDto update(SalonDto salonDto) {
        return null;
    }

    @Override
    public SalonDto findById(Long id) {
        return SalonMapper.INSTANCE.toSalonDto(salonRepo.findById(id).orElseThrow(()-> new RuntimeException("Salon not found!!!")));
    }

    @Override
    public List<SalonDto> findAll() {
        return SalonMapper.INSTANCE.toSalonDtoList(salonRepo.findAll());
    }

}
