package kg.easy.salonservice.services;

import kg.easy.salonservice.models.dtos.BranchDto;
import kg.easy.salonservice.models.dtos.inputs.BranchInput;

import java.util.List;

public interface BranchService extends BaseCrudService<BranchDto,Long> {
    BranchInput saveByPhone(BranchInput branchDto);
}
