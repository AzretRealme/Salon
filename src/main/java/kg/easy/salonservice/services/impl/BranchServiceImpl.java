package kg.easy.salonservice.services.impl;

import kg.easy.salonservice.dao.BranchRepo;
import kg.easy.salonservice.mappers.BranchMapper;
import kg.easy.salonservice.models.dtos.BranchDto;
import kg.easy.salonservice.models.dtos.PhoneDto;
import kg.easy.salonservice.models.enitities.Branch;
import kg.easy.salonservice.models.enitities.Phone;
import kg.easy.salonservice.services.BranchService;
import kg.easy.salonservice.services.PhoneService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BranchServiceImpl implements BranchService {


    private BranchRepo branchRepo;
    private PhoneService phoneService;

    @Override
    public BranchDto save(BranchDto branchDto) {
        Branch branch = BranchMapper.INTANCE.toBranch(branchDto);
        branch = branchRepo.save(branch);

        List<PhoneDto> phoneDtoList = phoneService.saveAll(branchDto.getPhoneDtoList(),branch.getId());
        branchDto = BranchMapper.INTANCE.toBranchDto(branch);
        branchDto.setPhoneDtoList(phoneDtoList);
        return branchDto;
    }

    @Override
    public BranchDto update(BranchDto branchDto) {
        return null;
    }

    @Override
    public BranchDto findById(Long id) {
        return null;
    }

    @Override
    public List<BranchDto> findAll() {
        return BranchMapper.INTANCE.toBrancgDtoList(branchRepo.findAll());
    }
}
