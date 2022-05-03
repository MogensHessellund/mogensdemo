package mogens.demo.services.repositories;

import mogens.demo.services.entities.Orkester;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrkesterRepository extends JpaRepository<Orkester, Long> {
    List<Orkester> findByForkortelse(String fork);
}
