package mogens.demo.lib.gateway.model;

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
public class MedlemModel {
    private long id;
    private int version;
    private String createdAt;
    private String brugernavn;
    private String navn;
    private String instrument;
    private boolean studerende;
    private String telefon;
    private int erfaring;
}
