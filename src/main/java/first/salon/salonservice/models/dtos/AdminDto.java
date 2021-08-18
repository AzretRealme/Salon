package first.salon.salonservice.models.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminDto {
    
    private Long id;
    private String name;
    private String login;
    private String password;
    private boolean status;
    
}
