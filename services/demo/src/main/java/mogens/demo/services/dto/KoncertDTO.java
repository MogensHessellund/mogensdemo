package mogens.demo.services.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import mogens.demo.lib.gateway.model.KoncertModel;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class KoncertDTO extends KontekstDTO {

    private String dato;
    private String sted;
    private String program;
    private String dirigent;

    public KoncertModel toModel() {
        return KoncertModel.builder()
                .id(this.getId())
                .version(this.getVersion())
                .createdAt(this.getCreatedAt())
                .version(this.getVersion())
                .dato(this.getDato())
                .sted(this.getSted())
                .program(this.getProgram())
                .dirigent(this.getDirigent())
                .build();
    }


}