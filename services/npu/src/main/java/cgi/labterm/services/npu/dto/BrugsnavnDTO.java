package cgi.labterm.services.npu.dto;

import cgi.labterm.lib.gateway.model.BrugsnavnModel;
import cgi.labterm.services.npu.entities.brugsnavn.Brugsnavn;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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