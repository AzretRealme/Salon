package kg.easy.salonservice.mappers;

import kg.easy.salonservice.models.dtos.AdminDto;
import kg.easy.salonservice.models.enitities.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AdminMapper {

    AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);

    Admin toAdmin(AdminDto adminDto);
    AdminDto toAdminDto(Admin admin);

    List<Admin> toAdminList(List<AdminDto> adminDtoList);
    List<AdminDto> toAdminDtoList(List<Admin> adminList);
}
