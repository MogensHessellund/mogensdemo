package mogens.demo.services.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import mogens.demo.lib.gateway.model.MedlemModel;
import mogens.demo.lib.gateway.model.OrkesterModel;
import mogens.demo.services.entities.Medlem;
import mogens.demo.services.entities.Orkester;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class OrkesterDTO extends KontekstDTO {

    private String navn;
    private String forkortelse;
    private String type;
    private String formand;
    private String telefon;
    private String beskrivelse;
    private String dirigent;
    private List<MedlemDTO> medlemmer;

    public static OrkesterDTO toDTO(Orkester ork) {
        OrkesterDTO dto = new OrkesterDTO();
        dto.setId(ork.getId());
        dto.setVersion(ork.getVersion());
        dto.setCreatedAt(ork.getCreatedAt() != null ? ork.getCreatedAt().toLocalDateTime().toString() : LocalDateTime.now().toString());
        dto.setBruger(ork.getBrugernavn());
        dto.setBeskrivelse(ork.getBeskrivelse());
        dto.setNavn(ork.getNavn());
        dto.setType(ork.getType().getNavn());
        dto.setTelefon(ork.getTelefon());
        dto.setBeskrivelse(ork.getBeskrivelse());
        dto.setDirigent(ork.getDirigent());
        dto.setMedlemmer(new ArrayList<>());
        dto.setFormand(ork.getFormand());
        dto.setForkortelse(ork.getForkortelse());
        for (Medlem medlem : ork.getMedlemmer()) {
            dto.getMedlemmer().add(MedlemDTO.toDto(medlem));
        }
        return dto;
    }

    public static OrkesterDTO toDTO(OrkesterModel orkModel) {
        OrkesterDTO dto = new OrkesterDTO();
        dto.setBeskrivelse(orkModel.getBeskrivelse());
        dto.setNavn(orkModel.getNavn());
        dto.setType(orkModel.getType());
        dto.setTelefon(orkModel.getTelefon());
        dto.setBeskrivelse(orkModel.getBeskrivelse());
        dto.setDirigent(orkModel.getDirigent());
        dto.setBruger(orkModel.getBrugernavn());
        dto.setId(orkModel.getId());
        dto.setForkortelse(orkModel.getForkortelse());
        dto.setFormand(orkModel.getFormand());
        return dto;
    }

    public OrkesterModel toModel() {

        List<MedlemModel> medlemmer = new ArrayList<>();
        for (MedlemDTO medlemDTO : this.getMedlemmer()) {
            medlemmer.add(medlemDTO.toModel());
        }

        return OrkesterModel.builder()
                .id(this.getId())
                .version(this.getVersion())
                .createdAt(this.getCreatedAt())
                .version(this.getVersion())
                .navn(this.getNavn())
                .forkortelse(this.getForkortelse())
                .type(this.getType())
                .formand(this.getFormand())
                .telefon(this.getTelefon())
                .beskrivelse(this.getBeskrivelse())
                .dirigent(this.getDirigent())
                .medlemmer(medlemmer)
                .build();
    }

}