package first.salon.salonservice.services.impl;

import first.salon.salonservice.dao.AdminRepo;
import first.salon.salonservice.mappers.AdminMapper;
import first.salon.salonservice.models.dtos.AdminDto;
import first.salon.salonservice.models.enitities.Admin;
import first.salon.salonservice.services.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {

    private AdminRepo adminRepo;
    @Override
    public AdminDto save(AdminDto adminDto) {
        Admin admin = AdminMapper.INSTANCE.toAdmin(adminDto);
        admin = adminRepo.save(admin);
        return AdminMapper.INSTANCE.toAdminDto(admin);
    }

    @Override
    public AdminDto update(AdminDto adminDto) {
        return null;
    }

    @Override
    public AdminDto findById(Long id) {
        return null;
    }

    @Override
    public List<AdminDto> findAll() {
        return null;
    }
}
