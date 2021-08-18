package first.salon.salonservice.dao;

import first.salon.salonservice.models.enitities.Salon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalonRepo  extends JpaRepository<Salon,Long> {
}
