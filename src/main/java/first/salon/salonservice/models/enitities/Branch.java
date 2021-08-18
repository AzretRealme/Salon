package first.salon.salonservice.models.enitities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "branches")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String address;
    private double lat;
    private double lon;
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "salon_id")
    private Salon salon;

    public Branch() {
    }

    public Branch(Long id) {
        this.id = id;
    }
}
