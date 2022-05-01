package cgi.labterm.lib.gateway.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class BrugsnavnModel {
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
    private String godkendendeOrganisation;
    private String type;
    private String term;
    private String sprog;
    private String notetekst;
    private List<NpubegrebModel> npubegreb;
    private UserModel userModel;
}
