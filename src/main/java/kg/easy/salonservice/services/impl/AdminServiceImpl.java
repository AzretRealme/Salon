package kg.easy.salonservice.services.impl;

import kg.easy.salonservice.dao.AdminRepo;
import kg.easy.salonservice.mappers.AdminMapper;
import kg.easy.salonservice.models.dtos.AdminDto;
import kg.easy.salonservice.models.enitities.Admin;
import kg.easy.salonservice.services.AdminService;
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
