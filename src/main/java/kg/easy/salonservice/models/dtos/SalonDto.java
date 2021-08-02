package kg.easy.salonservice.models.dtos;

import lombok.Data;

@Data
public class SalonDto {
    private Long id;
    private String name;
    private boolean active;
}
