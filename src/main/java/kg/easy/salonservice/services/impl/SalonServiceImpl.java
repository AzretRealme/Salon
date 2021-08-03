package kg.easy.salonservice.services.impl;

import kg.easy.salonservice.dao.SalonRepo;
import kg.easy.salonservice.exceptions.NotExistTime;
import kg.easy.salonservice.mappers.SalonMapper;
import kg.easy.salonservice.models.dtos.SalonDto;
import kg.easy.salonservice.models.enitities.Salon;
import kg.easy.salonservice.services.SalonService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        return null;
    }

    @Override
    public List<SalonDto> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<?> saveNewMethodByResponseEntity(SalonDto salonDto) throws NotExistTime {

        Salon salon = SalonMapper.INSTANCE.toSalon(salonDto);
        salon = salonRepo.save(salon);
        salonDto = SalonMapper.INSTANCE.toSalonDto(salon);
        if (salonDto != null) {
                throw new NotExistTime("Unsupported");

        }
        return ResponseEntity.ok("Success");

    }
}
