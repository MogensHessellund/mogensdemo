package mogens.demo.services.entities;

import mogens.demo.services.entities.base.Kontekst;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Table(name = "medlem")
@Entity
public class Medlem extends Kontekst {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String navn;

    @Column(nullable = false)
    private String instrument;

    @Column
    private boolean studerende;

    @Column
    private String telefon;

    @Column
    private int erfaring;

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

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public boolean isStuderende() {
        return studerende;
    }

    public void setStuderende(boolean studerende) {
        this.studerende = studerende;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public int getErfaring() {
        return erfaring;
    }

    public void setErfaring(int erfaring) {
        this.erfaring = erfaring;
    }
}