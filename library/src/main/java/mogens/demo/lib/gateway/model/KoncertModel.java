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
public class KoncertModel {
    private long id;
    private int version;
    private String createdAt;
    private String dato;
    private String sted;
    private String program;
    private String dirigent;
}
