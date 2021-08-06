package kg.easy.salonservice.models.dtos.responses;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservedHourDtoResponse {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
