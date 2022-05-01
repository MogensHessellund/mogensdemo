package cgi.labterm.lib.gateway.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ElementbegrebModel {
    private long id;
    private int version;
    private String status;
    private String createdAt;
    private String updatedAt;
    private String virkningFra;
    private String bruger;
    private int fejlkode;
    private String fejltekst;
    private String elementKode;
    private String releasecenter;
    private String erstatter;
    private String erstattetAf;
    private String definerendeIdHosOrg;
    private String definerendeTekst;
    private String organisationKortNavn;
    private String internalhandle;
    private String notetekst;
    private String termLang;
    private String termKort;
    private List<ElementtermModel> termer;
    private List<SoegetermModel> soegetermer;
    private List<TerminologirelationModel> terminologirelationer;
    private List<ElementbegrebModel> revisions; 
    private List<ElementtermModel> elementTermRevisions;
}

