package mogens.demo.gateway.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.log4j.Log4j2;
import mogens.demo.lib.gateway.model.BrugsnavnModel;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Log4j2
@RestController
@CrossOrigin(origins = {"http://localhost:4200","http://keycloak:4200","http://rinaudv.northeurope.cloudapp.azure.com"}, allowCredentials = "true")
public class BrugsnavnController {

    private final RestTemplate restTemplate;
    private final ControllerHelper controllerHelper;
    private final String serviceurl;

    public BrugsnavnController(RestTemplateBuilder restTemplateBuilder, ControllerHelper controllerHelper, String serviceurl) {
        this.restTemplate = restTemplateBuilder
                .build();
        this.controllerHelper = controllerHelper;
        this.serviceurl = serviceurl;
    }

    /**
     * Fremsøger Brugsnavn ud fra databasens id-kolonne. Ved positivt id er det fra de aktive elementer og ved negativt id er det fra kladdeland
     *
     * @param id id
     * @return modelobjekt eller en DemoelementNotfoundException
     */
    @GetMapping("/brugsnavn/id")
    public BrugsnavnModel getBrugsnavn(@RequestParam long id) {
        return restTemplate.getForObject(serviceurl + "/brugsnavn?id=" + id, BrugsnavnModel.class);
    }

    /**
     * Opretter Brugsnavn i kladde-tilstand. Der er ingen validering udover eksistensen af Releasecenter, samt at de angivne Elementbegreber eller Demobegreber skal eksistere
     *
     * @param elmt brugsnavn
     * @return Det nyoprettede DEMO-element, nu med id
     */
    @PostMapping("/demo/brugsnavn/new")
    public BrugsnavnModel newBrugsnavn(@RequestBody BrugsnavnModel elmt) {
        HttpEntity<BrugsnavnModel> request = new HttpEntity<>(elmt);
        var ret = restTemplate.postForEntity(serviceurl + "/brugsnavn/new", request, BrugsnavnModel.class);
        return ret.getBody();
    }

    /**
     * Opdaterer Brugsnavn.
     *
     * @param elmt Element
     * @return brugsnavnmodel Det opdaterede elmt. Hvis opdatering ikke kan gennemføres sendes fejlkode og fejltekst med i objektet.
     * Se fejlkoder i src/main/java/mogens/demo/lib/demo/DemoConst.java
     */
    @PostMapping("/demo/brugsnavn/update")
    public BrugsnavnModel updateBrugsnavn(@RequestBody BrugsnavnModel elmt) {
        HttpEntity<BrugsnavnModel> request = new HttpEntity<>(elmt);
        ResponseEntity<BrugsnavnModel> ret = restTemplate.postForEntity(serviceurl + "/brugsnavn/update", request,
                BrugsnavnModel.class);
        return ret.getBody();
    }
}
