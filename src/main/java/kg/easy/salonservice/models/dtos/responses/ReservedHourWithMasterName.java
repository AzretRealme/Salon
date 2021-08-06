package kg.easy.salonservice.models.dtos.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.easy.salonservice.models.dtos.MasterDto;
import kg.easy.salonservice.models.enums.ReserveStatus;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;
@Data
public class ReservedHourWithMasterName {
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime startTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime endTime;

    private MasterDto master;

    private Long clientId;

    @Enumerated(EnumType.STRING)
    private ReserveStatus reserveStatus;
}
