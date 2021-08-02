package kg.easy.salonservice.dao;

import kg.easy.salonservice.models.enitities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends JpaRepository<Client,Long> {
}
