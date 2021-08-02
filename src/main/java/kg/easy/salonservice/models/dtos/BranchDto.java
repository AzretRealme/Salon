package kg.easy.salonservice.models.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class BranchDto {

    private Long id;
    private String address;
    private double lat;
    private double lon;
    private boolean active;

    private SalonDto salon;
    private List<PhoneDto> phoneDtoList;

}
