package kg.easy.salonservice.mappers;

import kg.easy.salonservice.models.dtos.BranchDto;
import kg.easy.salonservice.models.enitities.Branch;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BranchMapper {

    BranchMapper INTANCE = Mappers.getMapper(BranchMapper.class);

    Branch toBranch(BranchDto branch);

    BranchDto toBranchDto(Branch branch);

    List<BranchDto> toBrancgDtoList(List<Branch> branchList);

    List<Branch> toBranchList(List<BranchDto> branchDtoList);
}
