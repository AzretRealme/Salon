package kg.easy.salonservice.models.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.easy.salonservice.models.enums.ReserveStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
public class ReservedHourDto {

    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime startTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime endTime;

    private MasterWorkDayDto masterWorkDay;

    private ClientDto client;

    @Enumerated(EnumType.STRING)
    private ReserveStatus reserveStatus;
}
