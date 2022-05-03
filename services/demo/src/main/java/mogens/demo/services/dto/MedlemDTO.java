package mogens.demo.services.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import mogens.demo.lib.gateway.model.MedlemModel;
import mogens.demo.services.entities.Medlem;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class MedlemDTO extends KontekstDTO {

    private String navn;
    private String instrument;
    private boolean studerende;
    private String telefon;
    private int erfaring;

    public static MedlemDTO toDto(Medlem medlem) {
        MedlemDTO dto = new MedlemDTO();
        dto.setId(medlem.getId());
        dto.setVersion(medlem.getVersion());
        dto.setCreatedAt(medlem.getCreatedAt().toLocalDateTime().toString());
        dto.setBruger(medlem.getBrugernavn());
        dto.setNavn(medlem.getNavn());
        dto.setInstrument(medlem.getInstrument());
        dto.setStuderende(medlem.isStuderende());
        dto.setTelefon(medlem.getTelefon());
        dto.setErfaring(medlem.getErfaring());
        return dto;
    }

    public MedlemModel toModel() {
        return MedlemModel.builder()
                .id(this.getId())
                .version(this.getVersion())
                .createdAt(this.getCreatedAt())
                .version(this.getVersion())
                .navn(this.getNavn())
                .instrument(this.getInstrument())
                .studerende(this.isStuderende())
                .telefon(this.getTelefon())
                .erfaring(this.getErfaring())
                .build();
    }

}