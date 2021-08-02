package kg.easy.salonservice.dao;

import kg.easy.salonservice.models.enitities.ReservedHours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReserveRepo extends JpaRepository<ReservedHours,Long> {
    List<ReservedHours> findAllByMasterWorkDayId(Long masterWorkDayId);
}
