package kg.easy.salonservice.services;

import kg.easy.salonservice.exceptions.NotExistTime;
import kg.easy.salonservice.models.dtos.SalonDto;
import org.springframework.http.ResponseEntity;

public interface SalonService  extends BaseCrudService<SalonDto,Long> {

}
