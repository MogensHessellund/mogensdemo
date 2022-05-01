package cgi.labterm.services.npu.entities;

import javax.persistence.*;

@Table(name = "bruger")
@Entity
public class Bruger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "brugernavn", nullable = false, unique = true)
    private String brugernavn;

    @Column(name = "fornavn", nullable = false)
    private String fornavn;

    @Column(name = "efternavn", nullable = false)
    private String efternavn;

    public String getEfternavn() {
        return efternavn;
    }

    public void setEfternavn(String efternavn) {
        this.efternavn = efternavn;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getBrugernavn() {
        return brugernavn;
    }

    public void setBrugernavn(String brugernavn) {
        this.brugernavn = brugernavn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}