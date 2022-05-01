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
public class TerminologirelationModel {
    private long id;
    private int version;
    private String status;
    private String createdAt;
    private String updatedAt;
    private String activeAt;
    private String virkningFra;
    private String brugernavn;
    private int fejlkode;
    private String fejltekst;
    private String releasecenter;
    private String terminologi;
    private String begreb;
    private String relationstype;
    private int maalbegreber;
    private String maalbegrebsnavn;
    private String notetekst;
    private ElementbegrebModel elementbegreb;
    private NpubegrebModel npubegreb;
}

