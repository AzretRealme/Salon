package first.salon.salonservice.services;

import first.salon.salonservice.models.dtos.BranchDto;
import first.salon.salonservice.models.dtos.inputs.BranchInput;

public interface BranchService extends BaseCrudService<BranchDto,Long> {
    BranchInput saveByPhone(BranchInput branchDto);
}
