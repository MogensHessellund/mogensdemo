package cgi.labterm.lib.gateway.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ElementtermModel {
    private long id;
    private int version;
    private String createdAt;
    private String updatedAt;
    private String virkningFra;
    private String bruger;
    private String status;
    private int fejlkode;
    private String fejltekst;
    private String navn;
    private String termLang;
    private String termKort;
    private String releasecenter;
    private String elementbegreb;
    private String sprog;
    private String sprogNavn;   // Bruges kun iforb.m. at hente historiske data fra backend til gui
    private String releasecenterNavn; // Bruges kun iforb.m. at hente historiske data fra backend til gui
    
    private List<ElementtermModel> termer;

}
