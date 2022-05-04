package mogens.demo.services.controller;

import mogens.demo.services.dto.OrkesterDTO;
import mogens.demo.services.service.OrkesterService;
import lombok.extern.java.Log;
import mogens.demo.lib.gateway.model.OrkesterModel;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Log
public class OrkesterController {
    final OrkesterService orkesterService;

    public OrkesterController(OrkesterService orkesterService) {
        this.orkesterService = orkesterService;
    }

    @GetMapping("/demo/orkester")
    public OrkesterModel getOrkester(@RequestParam(value = "id", defaultValue = "0") Long id) {
        Optional<OrkesterDTO> elmt = orkesterService.getById(id);
        return elmt.map(OrkesterDTO::toModel).orElseGet(OrkesterModel::new);
    }

    @PostMapping("/demo/orkester/new")
    OrkesterModel newOrkester(@RequestBody OrkesterModel newOrkester) {
        OrkesterDTO orkesterDTO = OrkesterDTO.toDTO(newOrkester);
        return orkesterService.createElementKladde(orkesterDTO).toModel();
    }

}
