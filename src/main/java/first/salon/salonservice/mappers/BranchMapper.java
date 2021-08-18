package first.salon.salonservice.mappers;

import first.salon.salonservice.models.dtos.BranchDto;
import first.salon.salonservice.models.enitities.Branch;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface BranchMapper {

    BranchMapper INTANCE = Mappers.getMapper(BranchMapper.class);

    default Branch toBranch(BranchDto branchDto) {
        Branch branch = new Branch();
        branch.setActive(branchDto.isActive());
        branch.setId(branchDto.getId());
        branch.setAddress(branchDto.getAddress());
        branch.setLat(branchDto.getLat());
        branch.setLon(branchDto.getLon());
        branch.setSalon(SalonMapper.INSTANCE.toSalon(branchDto.getSalonDto()));
        return branch;
    }

    default BranchDto toBranchDto(Branch branch) {
        BranchDto branchDto = new BranchDto();
        branchDto.setActive(branch.isActive());
        branchDto.setId(branch.getId());
        branchDto.setAddress(branch.getAddress());
        branchDto.setLat(branch.getLat());
        branchDto.setLon(branch.getLon());
        branchDto.setSalonDto(SalonMapper.INSTANCE.toSalonDto(branch.getSalon()));
        return branchDto;
    }

    default List<BranchDto> toBranchDtoList(List<Branch> branchList) {
        return branchList.stream().map(x -> {
            BranchDto branchDto = new BranchDto();
            branchDto.setActive(x.isActive());
            branchDto.setId(x.getId());
            branchDto.setAddress(x.getAddress());
            branchDto.setLat(x.getLat());
            branchDto.setLon(x.getLon());
            branchDto.setSalonDto(SalonMapper.INSTANCE.toSalonDto(x.getSalon()));
            return branchDto;
        }).collect(Collectors.toList());
    }

    default List<Branch> toBranchList(List<BranchDto> branchDtoList) {
        return branchDtoList.stream().map(x -> {
            Branch branch = new Branch();
            branch.setActive(x.isActive());
            branch.setId(x.getId());
            branch.setAddress(x.getAddress());
            branch.setLat(x.getLat());
            branch.setLon(x.getLon());
            branch.setSalon(SalonMapper.INSTANCE.toSalon(x.getSalonDto()));
            return branch;
        }).collect(Collectors.toList());
    }
}
