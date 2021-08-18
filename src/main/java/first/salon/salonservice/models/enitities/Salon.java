package first.salon.salonservice.models.enitities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "salons")
public class Salon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private boolean active;
}
