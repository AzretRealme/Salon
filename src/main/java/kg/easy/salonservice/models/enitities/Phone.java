package kg.easy.salonservice.models.enitities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "phones")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String phones;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;
}
