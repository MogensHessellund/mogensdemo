package mogens.demo.services.controller;

import mogens.demo.services.dto.BrugsnavnDTO;
import mogens.demo.services.service.BrugsnavnService;
import lombok.extern.java.Log;
import mogens.demo.lib.gateway.model.BrugsnavnModel;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://keycloak:4200", "http://rinaudv.northeurope.cloudapp.azure.com"}, allowedHeaders = "*", allowCredentials = "true")
@Log
public class BrugsnavnController {
    final BrugsnavnService brugsnavnService;

    public BrugsnavnController(BrugsnavnService brugsnavnService) {
        this.brugsnavnService = brugsnavnService;
    }

    @GetMapping("/demo/brugsnavn")
    public BrugsnavnModel getBrugsnavn(@RequestParam(value = "id", defaultValue = "0") Long id) {
        Optional<BrugsnavnDTO> elmt = brugsnavnService.getById(id);
        return elmt.map(BrugsnavnDTO::toModel).orElseGet(BrugsnavnModel::new);
    }

    @PostMapping("/demo/brugsnavn/new")
    BrugsnavnModel newBrugsnavn(@RequestBody BrugsnavnModel newBrugsnavn) {
        BrugsnavnDTO brugsnavnDTO = BrugsnavnDTO.toDTO(newBrugsnavn);
        return brugsnavnService.createElementKladde(brugsnavnDTO).toModel();
    }


}
