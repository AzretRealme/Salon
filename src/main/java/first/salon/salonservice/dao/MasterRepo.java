package first.salon.salonservice.dao;

import first.salon.salonservice.models.enitities.Master;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterRepo extends JpaRepository<Master,Long> {
}
