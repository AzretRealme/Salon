package kg.easy.salonservice.dao;

import kg.easy.salonservice.models.enitities.MasterWorkDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MasterWorkDayRepo  extends JpaRepository<MasterWorkDay,Long> {

    List<MasterWorkDay> findAllByBranchIdAndWorkDayIs(Long branchId, LocalDate date);

    boolean existsByIdAndStartTimeBeforeAndEndTimeAfter(Long id, LocalDateTime startTime, LocalDateTime endTime);
    boolean existsByIdAndStartTimeIsLessThanEqualAndEndTimeGreaterThanEqual(Long id, LocalDateTime startTime, LocalDateTime endTime);
}
