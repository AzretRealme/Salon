package first.salon.salonservice.models.dtos.inputs;

import first.salon.salonservice.models.dtos.PhoneDto;
import first.salon.salonservice.models.dtos.SalonDto;
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
