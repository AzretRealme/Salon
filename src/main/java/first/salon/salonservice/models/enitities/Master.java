package first.salon.salonservice.models.enitities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "masters")
public class Master {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

}
