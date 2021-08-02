package kg.easy.salonservice.models.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.easy.salonservice.models.enitities.Branch;
import kg.easy.salonservice.models.enitities.Master;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
public class MasterWorkDayDto {
    private Long id;

    private MasterDto master;


    private BranchDto branch;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate workDay;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime startTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime endTime;

    private LocalDateTime addDate;

    private LocalDateTime editDate;
}
