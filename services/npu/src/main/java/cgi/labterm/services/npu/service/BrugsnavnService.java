package cgi.labterm.services.npu.service;

import cgi.labterm.services.npu.dto.BrugsnavnDTO;
import cgi.labterm.services.npu.entities.brugsnavn.Brugsnavn;
import cgi.labterm.services.npu.repositories.brugsnavn.BrugsnavnRepository;
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
public class BrugsnavnService  {
    private final BrugsnavnRepository brugsnavnRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public BrugsnavnService(BrugsnavnRepository brugsnavnRepository) {
        this.brugsnavnRepository = brugsnavnRepository;
    }

    public List<BrugsnavnDTO> getByTerm(String term) {
        List<Brugsnavn> byTerm = brugsnavnRepository.findByTermLike("%"+term+"%");
        List<BrugsnavnDTO> brugsnavnDTOS = new ArrayList<>();
        for (Brugsnavn trm : byTerm) {
            brugsnavnDTOS.add(BrugsnavnDTO.toDTO(trm));
        }
        return brugsnavnDTOS;
    }

    public Optional<BrugsnavnDTO> getById(Long id) {
        Optional<Brugsnavn> byId = brugsnavnRepository.findById(id);
        return byId.map(BrugsnavnDTO::toDTO);
    }


    @Transactional
    public BrugsnavnDTO createElementKladde(BrugsnavnDTO dto) {
        Brugsnavn elmt = Brugsnavn.createBrugsnavn(dto);
        return BrugsnavnDTO.toDTO(brugsnavnRepository.save(elmt));
    }

}
