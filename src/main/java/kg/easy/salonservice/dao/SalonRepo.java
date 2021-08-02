package kg.easy.salonservice.dao;

import kg.easy.salonservice.models.enitities.Salon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalonRepo  extends JpaRepository<Salon,Long> {
}
