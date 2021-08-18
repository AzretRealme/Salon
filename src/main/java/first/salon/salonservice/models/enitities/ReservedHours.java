package first.salon.salonservice.models.enitities;

import first.salon.salonservice.models.enums.ReserveStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "reserved_hours")
public class ReservedHours {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @ManyToOne
    @JoinColumn(name = "master_work_day_id")
    private MasterWorkDay masterWorkDay;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @Enumerated(EnumType.STRING)
    private ReserveStatus reserveStatus;
}
