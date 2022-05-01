package cgi.labterm.lib.gateway.model;

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
public class OrganisationModel {
    private long id;
    private int version;
    private String createdAt;
    private String updatedAt;
    private String virkningFra;
    private String bruger;
    private int fejlkode;
    private String fejltekst;
    private String navn;
    private String kortNavn;
    private String beskrivelse;
    private String weblink;
    private String releasecenterSprog;
    private String kontaktNavn;
    private String kontaktMail;
    private String status;
    private String releasecenter;
    private Boolean markedAsReleasecenter;
    private String notetekst;
}
