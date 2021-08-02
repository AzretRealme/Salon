package kg.easy.salonservice.controllers;

import kg.easy.salonservice.models.dtos.AdminDto;
import kg.easy.salonservice.services.AdminService;
import kg.easy.salonservice.services.BaseCrudService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@AllArgsConstructor
public class AdminController implements BaseCrudController<AdminDto,Long> {

    private AdminService adminService;
    @Override
    public AdminDto save(AdminDto adminDto) {
        return adminService.save(adminDto);
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
