package first.salon.salonservice.dao;

import first.salon.salonservice.models.enitities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepo extends JpaRepository<Phone,Long> {

}
