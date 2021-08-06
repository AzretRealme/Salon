package kg.easy.salonservice.services.impl;

import kg.easy.salonservice.dao.MasterRepo;
import kg.easy.salonservice.mappers.MasterMapper;
import kg.easy.salonservice.models.dtos.MasterDto;
import kg.easy.salonservice.models.enitities.Master;
import kg.easy.salonservice.services.MasterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MasterServiceImpl implements MasterService {

    private MasterRepo masterRepo;
    @Override
    public MasterDto save(MasterDto masterDto) {
        System.out.println("MasterDto " + masterDto);
        Master master  = MasterMapper.INSTANCE.toMaster(masterDto);
        System.out.println("Master "+master);
        master = masterRepo.save(master);
        return MasterMapper.INSTANCE.toMasterDto(master);
    }

    @Override
    public MasterDto update(MasterDto masterDto) {
        return null;
    }

    @Override
    public MasterDto findById(Long id) {
        Master master = masterRepo.findById(id).orElseThrow(() -> new RuntimeException("Master not found!!!"));
        System.out.println(master);
        return MasterMapper.INSTANCE.toMasterDto(master);
    }

    @Override
    public List<MasterDto> findAll() {
        return MasterMapper.INSTANCE.toMasterDtoList(masterRepo.findAll());
    }
}
