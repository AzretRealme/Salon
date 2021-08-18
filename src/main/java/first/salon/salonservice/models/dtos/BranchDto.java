package first.salon.salonservice.models.dtos;

import lombok.Data;

@Data
public class BranchDto {
    private Long id;
    private String address;
    private double lat;
    private double lon;
    private boolean active;
    private SalonDto salonDto;
}
