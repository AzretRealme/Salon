package kg.easy.salonservice.services;

import kg.easy.salonservice.models.dtos.PhoneDto;

import java.util.List;

public interface PhoneService extends BaseCrudService<PhoneDto,Long>{

    List<PhoneDto> saveAll(List<PhoneDto> phoneDtoList, Long id);
}
