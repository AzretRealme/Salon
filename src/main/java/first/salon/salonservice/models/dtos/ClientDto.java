package first.salon.salonservice.models.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDto {
    private Long id;
    private String name;
    private String phone;
    private String pin;
}
