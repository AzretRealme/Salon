package kg.easy.salonservice.models.dtos.inputs;

import kg.easy.salonservice.models.dtos.PhoneDto;
import kg.easy.salonservice.models.dtos.SalonDto;
import lombok.Data;

import java.util.List;

@Data
public class BranchInput {
    private Long id;
    private String address;
    private double lat;
    private double lon;
    private boolean active;
    private SalonDto salonDto;
    private List<PhoneDto> phoneDtoList;
}
