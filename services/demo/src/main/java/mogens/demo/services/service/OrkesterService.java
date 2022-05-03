package mogens.demo.services.service;

import mogens.demo.services.dto.OrkesterDTO;
import mogens.demo.services.entities.Orkester;
import mogens.demo.services.repositories.OrkesterRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@Log4j2
public class OrkesterService  {
    private final OrkesterRepository orkesterRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public OrkesterService(OrkesterRepository orkesterRepository) {
        this.orkesterRepository = orkesterRepository;
    }

    public List<OrkesterDTO> getByForkotelse(String forkortelse) {
        List<Orkester> byTerm = orkesterRepository.findByForkortelse(forkortelse);
        List<OrkesterDTO> orkesterDTOS = new ArrayList<>();
        for (Orkester trm : byTerm) {
            orkesterDTOS.add(OrkesterDTO.toDTO(trm));
        }
        return orkesterDTOS;
    }

    public Optional<OrkesterDTO> getById(Long id) {
        Optional<Orkester> byId = orkesterRepository.findById(id);
        return byId.map(OrkesterDTO::toDTO);
    }


    @Transactional
    public OrkesterDTO createElementKladde(OrkesterDTO dto) {
        Orkester elmt = Orkester.createOrkester(dto);
        return OrkesterDTO.toDTO(orkesterRepository.save(elmt));
    }

}
