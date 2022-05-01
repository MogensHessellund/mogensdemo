package cgi.labterm.services.npu.controller;

import cgi.labterm.lib.gateway.model.*;
import cgi.labterm.services.npu.dto.BrugsnavnDTO;
import cgi.labterm.services.npu.service.BrugsnavnService;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://keycloak:4200", "http://rinaudv.northeurope.cloudapp.azure.com"}, allowedHeaders = "*", allowCredentials = "true")
@Log
public class BrugsnavnController {
    final BrugsnavnService brugsnavnService;

    public BrugsnavnController(BrugsnavnService brugsnavnService) {
        this.brugsnavnService = brugsnavnService;
    }

    @GetMapping("/npu/brugsnavn")
    public BrugsnavnModel getBrugsnavn(@RequestParam(value = "id", defaultValue = "0") Long id) {
        Optional<BrugsnavnDTO> elmt = brugsnavnService.getById(id);
        return elmt.map(BrugsnavnDTO::toModel).orElseGet(BrugsnavnModel::new);
    }

    @PostMapping("/npu/brugsnavn/new")
    BrugsnavnModel newBrugsnavn(@RequestBody BrugsnavnModel newBrugsnavn) {
        BrugsnavnDTO brugsnavnDTO = BrugsnavnDTO.toDTO(newBrugsnavn);
        return brugsnavnService.createElementKladde(brugsnavnDTO).toModel();
    }


}
