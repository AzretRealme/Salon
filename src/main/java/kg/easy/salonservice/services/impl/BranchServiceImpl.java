package kg.easy.salonservice.services.impl;

import kg.easy.salonservice.dao.BranchRepo;
import kg.easy.salonservice.mappers.BranchMapper;
import kg.easy.salonservice.models.dtos.BranchDto;
import kg.easy.salonservice.models.dtos.PhoneDto;
import kg.easy.salonservice.models.dtos.inputs.BranchInput;
import kg.easy.salonservice.models.enitities.Branch;
import kg.easy.salonservice.services.BranchService;
import kg.easy.salonservice.services.PhoneService;
import kg.easy.salonservice.services.SalonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BranchServiceImpl implements BranchService {


    private BranchRepo branchRepo;
    private PhoneService phoneService;
    private SalonService salonService;

    public BranchInput saveByPhone(BranchInput branchDto) {
        BranchDto branchDto1 = new BranchDto();
        branchDto1.setSalonDto(salonService.findById(branchDto.getSalonDto().getId()));
        branchDto1.setActive(branchDto.isActive());
        branchDto1.setAddress(branchDto.getAddress());
        branchDto1.setLat(branchDto.getLat());
        branchDto1.setLon(branchDto.getLon());

        Branch branch = BranchMapper.INTANCE.toBranch(branchDto1);
        branch = branchRepo.save(branch);

        List<PhoneDto> phoneDtoList = phoneService.saveAll(branchDto.getPhoneDtoList(),branch.getId());
        branchDto1 = BranchMapper.INTANCE.toBranchDto(branch);
        branchDto.setPhoneDtoList(phoneDtoList);
        branchDto.setId(branchDto1.getId());
        return branchDto;
    }

    @Override
    public BranchDto save(BranchDto branchDto) {
        return BranchMapper.INTANCE.toBranchDto(branchRepo.save(BranchMapper.INTANCE.toBranch(branchDto)));
    }

    @Override
    public BranchDto update(BranchDto branchDto) {
        return null;
    }

    @Override
    public BranchDto findById(Long id) {
        Branch branch = branchRepo.findById(id).orElseThrow(() -> new RuntimeException("Branch not found!!!"));
        System.out.println("On find by id branch " + branch);
        return BranchMapper.INTANCE.toBranchDto(branch);
    }

    @Override
    public List<BranchDto> findAll() {
        return BranchMapper.INTANCE.toBranchDtoList(branchRepo.findAll());
    }
}
