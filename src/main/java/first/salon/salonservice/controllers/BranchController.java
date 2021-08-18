package first.salon.salonservice.controllers;

import first.salon.salonservice.models.dtos.BranchDto;
import first.salon.salonservice.models.dtos.inputs.BranchInput;
import first.salon.salonservice.services.BranchService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/save-with-phones")
    BranchInput saveCustom(@RequestBody BranchInput branchInput){
        return branchService.saveByPhone(branchInput);
    }
}
