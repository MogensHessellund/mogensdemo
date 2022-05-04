package mogens.demo.gateway.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.extern.log4j.Log4j2;
import mogens.demo.lib.gateway.model.OrkesterModel;
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
public class OrkesterController {

    private final RestTemplate restTemplate;
    private final ControllerHelper controllerHelper;
    private final String serviceurl;

    public OrkesterController(RestTemplateBuilder restTemplateBuilder, ControllerHelper controllerHelper, String serviceurl) {
        this.restTemplate = restTemplateBuilder
                .build();
        this.controllerHelper = controllerHelper;
        this.serviceurl = serviceurl;
    }

    /**
     * Fremsøger Orkester ud fra databasens id-kolonne.
     *
     * @param id id
     * @return modelobjekt eller en DemoelementNotfoundException
     */
    @GetMapping("/demo/orkester/id")
    public OrkesterModel getOrkester(@RequestParam long id) {
        return restTemplate.getForObject(serviceurl + "/orkester?id=" + id, OrkesterModel.class);
    }

    /**
     * Opretter Orkester i kladde-tilstand. D
     *
     * @param elmt orkester
     * @return Det nyoprettede DEMO-element, nu med id
     */
    @PostMapping("/demo/orkester/new")
    @Operation(description = "Opretter orkester")
    public OrkesterModel newOrkester(@RequestBody OrkesterModel elmt) {
        HttpEntity<OrkesterModel> request = new HttpEntity<>(elmt);
        var ret = restTemplate.postForEntity(serviceurl + "/orkester/new", request, OrkesterModel.class);
        return ret.getBody();
    }

    /**
     * Opdaterer Orkester.
     *
     * @param elmt Element
     * @return orkestermodel Det opdaterede elmt.
     */
    @PostMapping("/demo/orkester/update")
    @Operation(description = "Opretter orkester")
    public OrkesterModel updateOrkester(@RequestBody OrkesterModel elmt) {
        HttpEntity<OrkesterModel> request = new HttpEntity<>(elmt);
        ResponseEntity<OrkesterModel> ret = restTemplate.postForEntity(serviceurl + "/orkester/update", request,
                OrkesterModel.class);
        return ret.getBody();
    }
}
