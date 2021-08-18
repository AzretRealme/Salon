package first.salon.salonservice.dao;

import first.salon.salonservice.models.enitities.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepo extends JpaRepository<Branch,Long> {
}
