package cgi.labterm.services.npu.repositories.brugsnavn;

import cgi.labterm.services.npu.entities.brugsnavn.Brugsnavn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BrugsnavnRepository extends JpaRepository<Brugsnavn, Long> {
    List<Brugsnavn> findByTermLike(String term);
}
