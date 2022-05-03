package mogens.demo.lib.gateway.model;

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
public class OrkesterModel {
    private long id;
    private int version;
    private String createdAt;
    private String brugernavn;
    private String navn;
    private String forkortelse;
    private String type;
    private String formand;
    private String telefon;
    private String beskrivelse;
    private String dirigent;
    private List<MedlemModel> medlemmer;
}
