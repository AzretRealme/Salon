package kg.easy.salonservice.controllers;

import kg.easy.salonservice.exceptions.NotExistTime;
import kg.easy.salonservice.models.dtos.BranchDto;
import kg.easy.salonservice.services.BaseCrudService;
import kg.easy.salonservice.services.BranchService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/branch")
public class BranchController implements BaseCrudController<BranchDto,Long> {

    private BranchService branchService;


    @Override
    public BranchDto save(BranchDto branchDto) {

            return branchService.save(branchDto);

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
        return branchService.findAll();
    }
}
