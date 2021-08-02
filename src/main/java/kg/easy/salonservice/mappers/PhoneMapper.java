package kg.easy.salonservice.mappers;

import kg.easy.salonservice.models.dtos.PhoneDto;
import kg.easy.salonservice.models.enitities.Phone;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PhoneMapper {

    PhoneMapper INSTANCE = Mappers.getMapper(PhoneMapper.class);

    Phone toPhone(PhoneDto phoneDto);
    PhoneDto toPhoneDto(Phone phone);

    List<Phone> toPhoneList(List<PhoneDto> phoneDtoList);

    List<PhoneDto> toPhoneDtoList(List<Phone> phoneList);
}
