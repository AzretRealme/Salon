package kg.easy.salonservice.models.dtos.inputs;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.easy.salonservice.models.dtos.BranchDto;
import kg.easy.salonservice.models.dtos.MasterDto;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class MasterWorkDayInput {
    private Long id;

    private Long masterId;


    private Long branchId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate workDay;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime startTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime endTime;
}
