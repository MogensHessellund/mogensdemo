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
public class NoteModel {
    private long id;
    private int version;
    private String createdAt;
    private String updatedAt;
    private String bruger;
    private String tekst;
    private long businessId;
}
