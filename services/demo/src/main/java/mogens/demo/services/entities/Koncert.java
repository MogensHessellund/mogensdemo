package mogens.demo.services.entities;

import mogens.demo.services.entities.base.Kontekst;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Table(name = "koncert")
@Entity
public class Koncert extends Kontekst {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String dato;

    @Column(nullable = false)
    private String sted;

    @Column(nullable = false)
    private String program;

    @Column
    private String dirigent;

    @ManyToOne
    @JoinColumn(name = "orkester_id")
    private Orkester orkester;

    public Orkester getOrkester() {
        return orkester;
    }

    public void setOrkester(Orkester orkester) {
        this.orkester = orkester;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public String getSted() {
        return sted;
    }

    public void setSted(String sted) {
        this.sted = sted;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getDirigent() {
        return dirigent;
    }

    public void setDirigent(String dirigent) {
        this.dirigent = dirigent;
    }
}