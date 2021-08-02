package kg.easy.salonservice.dao;

import kg.easy.salonservice.models.enitities.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepo extends JpaRepository<Branch,Long> {
}
