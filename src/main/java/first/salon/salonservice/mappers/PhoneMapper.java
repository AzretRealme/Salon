package first.salon.salonservice.mappers;

import first.salon.salonservice.models.dtos.PhoneDto;
import first.salon.salonservice.models.enitities.Phone;
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
