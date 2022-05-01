package cgi.labterm.lib.gateway.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserModel {
    private String brugernavn;
    private String navn;
    private String sprog;
    private String releasecenter;
    private List<String> releaseCentreCreate;
    private List<String> releaseCentreRead;
    private List<String> sproglist;
}
