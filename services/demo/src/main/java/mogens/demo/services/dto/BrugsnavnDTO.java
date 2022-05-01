package mogens.demo.services.dto;

import mogens.demo.lib.gateway.model.BrugsnavnModel;
import mogens.demo.services.entities.brugsnavn.Brugsnavn;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class BrugsnavnDTO extends KontekstDTO {


    public  BrugsnavnModel toModel( ) {
        return null;
    }

    public static BrugsnavnDTO toDTO(BrugsnavnModel newBrugsnavn) {
        return null;
    }


    public static BrugsnavnDTO toDTO(Brugsnavn newBrugsnavn) {
        return null;
    }

}