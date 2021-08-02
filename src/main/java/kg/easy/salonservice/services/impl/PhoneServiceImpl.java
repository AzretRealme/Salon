package kg.easy.salonservice.services.impl;

import kg.easy.salonservice.dao.PhoneRepo;
import kg.easy.salonservice.mappers.PhoneMapper;
import kg.easy.salonservice.models.dtos.PhoneDto;
import kg.easy.salonservice.models.enitities.Branch;
import kg.easy.salonservice.models.enitities.Phone;
import kg.easy.salonservice.services.PhoneService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PhoneServiceImpl implements PhoneService {

    private PhoneRepo phoneRepo;

    @Override
    public PhoneDto save(PhoneDto phoneDto) {
        Phone phone = PhoneMapper.INSTANCE.toPhone(phoneDto);
        phone = phoneRepo.save(phone);
        return PhoneMapper.INSTANCE.toPhoneDto(phone);
    }

    @Override
    public PhoneDto update(PhoneDto phoneDto) {
        return null;
    }

    @Override
    public PhoneDto findById(Long id) {
        return null;
    }

    @Override
    public List<PhoneDto> findAll() {
        return null;
    }

    @Override
    public List<PhoneDto> saveAll(List<PhoneDto> phoneDtoList, Long id) {
        List<Phone> phoneList = PhoneMapper.INSTANCE.toPhoneList(phoneDtoList);
        for (Phone p:phoneList){
            p.setBranch(new Branch(id));
        }
        phoneList = phoneRepo.saveAll(phoneList);
        return PhoneMapper.INSTANCE.toPhoneDtoList(phoneList);
    }
}
