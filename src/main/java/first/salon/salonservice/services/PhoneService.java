package first.salon.salonservice.services;

import first.salon.salonservice.models.dtos.PhoneDto;

import java.util.List;

public interface PhoneService extends BaseCrudService<PhoneDto,Long>{

    List<PhoneDto> saveAll(List<PhoneDto> phoneDtoList, Long id);
}
