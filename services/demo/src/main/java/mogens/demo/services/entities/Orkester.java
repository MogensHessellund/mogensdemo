package mogens.demo.services.entities;

import mogens.demo.services.dto.MedlemDTO;
import mogens.demo.services.dto.OrkesterDTO;
import mogens.demo.services.entities.base.Kontekst;
import mogens.demo.services.entities.enums.OrkesterType;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Audited
@Table(name = "orkester")
@Entity
public class Orkester extends Kontekst {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String navn;

    @Column
    private String forkortelse;

    @Column
    private OrkesterType type;

    @Column
    private String formand;

    @Column
    private String telefon;

    @Column
    private String beskrivelse;

    @Column
    private String dirigent;

    @OneToMany(mappedBy = "orkester")
    private List<Medlem> medlemmer = new ArrayList<>();

    public static Orkester createOrkester(OrkesterDTO dto) {
        return null;
    }

    public List<Medlem> getMedlemmer() {
        return medlemmer;
    }

    public void setMedlemmer(List<Medlem> medlemmer) {
        this.medlemmer = medlemmer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getForkortelse() {
        return forkortelse;
    }

    public void setForkortelse(String forkortelse) {
        this.forkortelse = forkortelse;
    }

    public OrkesterType getType() {
        return type;
    }

    public void setType(OrkesterType type) {
        this.type = type;
    }

    public String getFormand() {
        return formand;
    }

    public void setFormand(String formand) {
        this.formand = formand;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public String getDirigent() {
        return dirigent;
    }

    public void setDirigent(String dirigent) {
        this.dirigent = dirigent;
    }
}