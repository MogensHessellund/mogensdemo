package cgi.labterm.gateway.controller;

import cgi.labterm.lib.gateway.model.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.log4j.Log4j2;
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
     * @return modelobjekt eller en NpuelementNotfoundException
     */
    @GetMapping("/brugsnavn/id")
    public BrugsnavnModel getBrugsnavn(@RequestParam long id) {
        return restTemplate.getForObject(serviceurl + "/brugsnavn?id=" + id, BrugsnavnModel.class);
    }

    /**
     * Fremsøger Brugsnavner NB! Der udestår at tilføje predikater, bl.a. brugsnavne. Også den trefløjede søgning.
     *
     * @param query      Et array af predikater der and-joines til den endelige query. NB! søgning er casesensitiv. Bemærk at operand ikke er relevant for alle typer af felter, idet det
     *                   for nogle er implicit
     *                   FIELDNAME:
     *                   "any", indhold af value bruges i en likequery indholdende %+"value"+%, pt. kun brugsnavn
     *                   "term", (Brugsnavn) alm. strengsøgning
     *                   "org", (Org. KortNavn) like søgning
     *                   [Syntaxtype + fritekst søg]
     *                        Syntaxtype - angiv NPUKODE for at søge i npukode, eller SYSTEM/KOMPOSITION/EGENSKABSART/ENHED - for at søge ned i lang helterm -
     *                        Eksempel, finder søgetermer hvor npukoden indeholder 0136
     *                               [
     *                                 {
     *                                   "fieldName": "syntaxtype",
     *                                   "value": "NPUKODE",
     *                                   "operand": "string"
     *                                 },
     *                                 {
     *                                   "fieldName": "fritekst",
     *                                   "value": "1036",
     *                                   "operand": "string"
     *                                 }
     *                               ]
     *                   "sprog",
     *                   "status", indhold af value behandles som en komma-separeret liste af status (AKTIV,KLAR_TIL_FRIGIV osv), der så indgår i et indlejret or-predicate (status = 'AKTIV' or status = '....)
     *                   "brugernavn" (AKA Redaktør), like strengsøgning
     *                   "rc", indhold af value behandles som en komma-separeret liste af releasecentrekortnavne, der så indgår i et indlejret or-predicate (ligesom status, se ovenfor)
     *                   Trefløjet søg - eksempel
     *                          [
     *                            {
     *                              "fieldName": "trflj.relation",
     *                              "value": "2022-03-17",
     *                              "operand": "before"
     *                            },
     *                            {
     *                              "fieldName": "trflj.status",
     *                              "value": "KLAR_TIL_FRIGIV",
     *                              "operand": ""
     *                            }
     *                          ]
     * @param limit      kan bruges til at begrænse resultatsættet. Defaultværdi er -1, og så er der ingen begrænsning
     * @param offset     kan bruges til at start fremsøgning efter et bestemt antal rækker. Defaultværdi er -1, og så er der ingen begrænsning
     * @param sortcolumn der kan angives et kolonnenavn til brug for 'order by'
     * @param order        ved true sorteres efter stigende eller sorteres efter faldende
     * @return liste af Brugsnavner.
     */
    @PostMapping("/brugsnavner")
    public List<BrugsnavnModel> getBrugsnavns(@RequestBody QueryModel[] query,
                                              @RequestParam(value = "limit", defaultValue = "-1") int limit,
                                              @RequestParam(value = "offset", defaultValue = "-1") int offset,
                                              @RequestParam(value = "sortcolumn", defaultValue = "") String sortcolumn,
                                              @RequestParam(value = "order", defaultValue = "asc") String order) {

        long start = System.nanoTime();

        UserModel userModel = controllerHelper.extractUserModel();
        UserQueryModel userQueryModel = new UserQueryModel(userModel, query);
        ResponseEntity<BrugsnavnModel[]> response = restTemplate
                .postForEntity(serviceurl + "/brugsnavner/?limit=" + limit + "&offset=" + offset + "&sortcolumn=" + sortcolumn + "&order=" + order, userQueryModel, BrugsnavnModel[].class);
        System.out.println("Brugsnavnmodeller hentet på " + (System.nanoTime() - start)/1000000 + " millisekunder");
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }

    @Operation(summary = "Brugsnavne ud fra term-snippet",
            description = "Søger blandt brugsnavne ud fra del af term")
    @GetMapping("/brugsnavn/term")
    public List<BrugsnavnModel> getBrugsnavnByTerm(@RequestParam String term) {
        UserModel userModel = controllerHelper.extractUserModel();  //ToDo - afgræns på releasecentre bruger har læseadgang til
        ResponseEntity<BrugsnavnModel[]> forEntity = restTemplate.getForEntity(serviceurl + "/brugsnavn/term?term=" + term, BrugsnavnModel[].class);
        return Arrays.asList(Objects.requireNonNull(forEntity.getBody()));
    }

    /**
     * Opretter et antal kopier af entiteten. Kopierne oprettes i kladdeland med stastus 'KLADDE' og får tildelt en systemmæssig unik NPU-kode
     *
     * @param id     Id enten kladde eller aktiv element
     * @param number antal kopier
     * @return liste indeholder de nyoprettede elementer
     */
    @PostMapping("/brugsnavn/copies")
    public List<BrugsnavnModel> makeCopies(@RequestParam long id,
                                           @RequestParam int number) {
        UserModel userModel = controllerHelper.extractUserModel();
        ResponseEntity<BrugsnavnModel[]> response = restTemplate
                .postForEntity(serviceurl + "/brugsnavn/copies?id=" + id + "&number=" + number + "&rc=" + userModel.getReleasecenter(), userModel, BrugsnavnModel[].class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }

    /**
     * Opretter Brugsnavn i kladde-tilstand. Der er ingen validering udover eksistensen af Releasecenter, samt at de angivne Elementbegreber eller Npubegreber skal eksistere
     *
     * @param elmt brugsnavn
     * @return Det nyoprettede NPU-element, nu med id
     */
    @PostMapping("/npu/brugsnavn/new")
    public BrugsnavnModel newBrugsnavn(@RequestBody BrugsnavnModel elmt) {
        UserModel userModel = controllerHelper.extractUserModel();
        elmt.setReleasecenter(userModel.getReleasecenter());
        elmt.setBrugernavn(userModel.getBrugernavn());
        HttpEntity<BrugsnavnModel> request = new HttpEntity<>(elmt);
        var ret = restTemplate.postForEntity(serviceurl + "/brugsnavn/new", request, BrugsnavnModel.class);
        return ret.getBody();
    }

    /**
     * Skifter status på Brugsnavn iht. reglerne for statusskift.
     * Statusskift fører til versionshistorik.
     *
     * Særligt for skiftet til KLAR_TIL_FRIGIV sker der er en validering af data, og data flyttes fra kladde-tabel til entitetens tabel (slet + opret) incl. syntaksgruppe og noter
     *
     * @param elmt Brugsnavnmodel.
     * @return brugsnavnmodel Det opdaterede element. Hvis statusskift ikke kan gennemføres sendes fejlkode og fejltekst med i objektet. Se fejlkoder i src/main/java/cgi/labterm/lib/npu/NpuConst.java
     */
    @PostMapping("/npu/brugsnavn/changestatus")
    public BrugsnavnModel changestatusBrugsnavn(@RequestBody BrugsnavnModel elmt) {
        UserModel userModel = controllerHelper.extractUserModel();
        elmt.setReleasecenter(userModel.getReleasecenter());
        elmt.setBrugernavn(userModel.getBrugernavn());
        HttpEntity<BrugsnavnModel> request = new HttpEntity<>(elmt);
        ResponseEntity<BrugsnavnModel> ret = restTemplate.postForEntity(serviceurl + "/brugsnavn/changestatus", request,
                BrugsnavnModel.class);
        return ret.getBody();
    }

    /**
     * Opdaterer Brugsnavn.
     *
     * @param elmt Element
     * @return brugsnavnmodel Det opdaterede elmt. Hvis opdatering ikke kan gennemføres sendes fejlkode og fejltekst med i objektet.
     * Se fejlkoder i src/main/java/cgi/labterm/lib/npu/NpuConst.java
     */
    @PostMapping("/npu/brugsnavn/update")
    public BrugsnavnModel updateBrugsnavn(@RequestBody BrugsnavnModel elmt) {
        UserModel userModel = controllerHelper.extractUserModel();
        elmt.setReleasecenter(userModel.getReleasecenter());
        elmt.setBrugernavn(userModel.getBrugernavn());
        HttpEntity<BrugsnavnModel> request = new HttpEntity<>(elmt);
        ResponseEntity<BrugsnavnModel> ret = restTemplate.postForEntity(serviceurl + "/brugsnavn/update", request,
                BrugsnavnModel.class);
        return ret.getBody();
    }

    /**
     * Henter liste af noter for dette Brugsnavn sorteret faldende.
     *
     * @param id id på Brugsnavnet - enten fra kladde-tabel eller entitetstabel
     * @return Liste af noter sorteret efter faldende id
     */
    @GetMapping("/brugsnavn/noterforelement")
    public List<NoteModel> noterForBrugsnavn(@RequestParam(value = "id", defaultValue = "0") long id) {
        ResponseEntity<NoteModel[]> response = restTemplate
                .getForEntity(serviceurl + "/brugsnavn/noterforelement?id="+id, NoteModel[].class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }

    /**
     * Tilføjer note til Brugsnavn. Det kan enten være et Brugsnavn i kladdeland eller frigivet Brugsnavn
     * Derudover opdateres Brugsnavn, der har en pegepind til den nyeste note, som vil fremgå af oversigter
     *
     * @param note Den nye note. Noten indeholder id på Brugsnavn i kladdeland eller frigivet entitet
     * @return Den opdaterede note
     */
    @PostMapping("/brugsnavn/addnote")
    public NoteModel addNote(@RequestBody NoteModel note) {
        UserModel userModel = controllerHelper.extractUserModel();
        note.setBruger(userModel.getBrugernavn());
        HttpEntity<NoteModel> request = new HttpEntity<>(note);
        ResponseEntity<NoteModel> ret = restTemplate.postForEntity(serviceurl + "/brugsnavn/newnote", request,
                NoteModel.class);
        return ret.getBody();
    }

    /**
     * Sletter den angivne note. Hvis det er den nyeste note opdateres relationen Brugsnavn->Nyeste Note
     *
     * @param id Notens id
     */
    @PostMapping("/brugsnavn/deletenote")
    public void deleteNoteForBrugsnavn(@RequestBody Long id) {
        HttpEntity<Long> request = new HttpEntity<>(id);
        restTemplate.postForEntity(serviceurl + "/brugsnavn/note/delete", request,
                Void.class);
    }

    /**
     * Opdaterer teksten på en note.
     *
     * @param note Note indeholdende id på eksisterende note og ny tekst
     * @return opdateret note
     */
    @PostMapping("/brugsnavn/updatenote")
    public NoteModel updateNoteForBrugsnavn(@RequestBody NoteModel note) {
        UserModel userModel = controllerHelper.extractUserModel();
        note.setBruger(userModel.getBrugernavn());
        HttpEntity<NoteModel> request = new HttpEntity<>(note);
        ResponseEntity<NoteModel> ret = restTemplate.postForEntity(serviceurl + "/brugsnavn/note/update", request,
                NoteModel.class);
        return ret.getBody();
    }

    @PostMapping("/npu/brugsnavn/changestatusonmultiple")
    @ResponseBody
    List<BrugsnavnModel> changeStatusOnMultipleBrugsnavns(@RequestParam(name = "orgs") List<Long> brugsnavns,
                                                                @RequestParam(name = "newStatus") String newStatus) {
        log.info("changeStatusOnMultipleBrugsnavns called...");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("newStatus", newStatus);
        if (brugsnavns != null) {
            for (Long id : brugsnavns) {
                if (map.get("orgs")==null || !Objects.requireNonNull(map.get("orgs")).contains(id)) {
                    map.add("orgs", id);
                }
            }
        }

        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(map, headers);

        ResponseEntity<BrugsnavnModel[]> ret = restTemplate.postForEntity(
                serviceurl + "/brugsnavn/changestatusonmultiple", request, BrugsnavnModel[].class);
        return Arrays.asList(Objects.requireNonNull(ret.getBody()));
    }

    @GetMapping("/brugsnavn/revisions")
    public List<BrugsnavnModel> getBrugsnavnRevisions(@RequestParam(value = "id", defaultValue = "0") long id) {
        log.info("getBrugsnavnRevisions called...");
        ResponseEntity<BrugsnavnModel[]> response = restTemplate
                .getForEntity(serviceurl + "/brugsnavn/revisions/?id=" + id, BrugsnavnModel[].class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));

    }
}
