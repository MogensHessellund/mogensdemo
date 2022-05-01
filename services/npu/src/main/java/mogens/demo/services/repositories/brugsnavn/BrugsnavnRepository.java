package mogens.demo.services.repositories.brugsnavn;

import mogens.demo.services.entities.brugsnavn.Brugsnavn;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrugsnavnRepository extends JpaRepository<Brugsnavn, Long> {
    List<Brugsnavn> findByTermLike(String term);
}
