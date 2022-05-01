package cgi.labterm.services.npu.entities.base;

import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;

@SuppressWarnings("unused")
@Audited
@MappedSuperclass
public class Kontekst implements Serializable {


    @Version
    @Column(name = "optlock", nullable = false)
    private Integer version;

    @Column(name = "virkning_fra")
    private LocalDate virkningFra;

    @Column(name = "active_at")
    private Timestamp activeAt;

    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP", name = "created_at", insertable = false, updatable = false)
    private Timestamp createdAt;

    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE", name = "updated_at", insertable = false)
    private Timestamp updatedAt;

    @Column(name = "brugernavn", nullable = false)
    private String brugernavn;

    @PreUpdate
    public void preUpdateFunction(){
        updatedAt = Timestamp.from(Instant.now());
    }

    public LocalDate getVirkningFra() {
        return virkningFra;
    }

    public void setVirkningFra(LocalDate virkningFra) {
        this.virkningFra = virkningFra;
    }


    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getBrugernavn() {
        return brugernavn;
    }

    public void setBrugernavn(String brugernavn) {
        this.brugernavn = brugernavn;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Timestamp getActiveAt() {
        return activeAt;
    }

    public void setActiveAt(Timestamp activeAt) {
        this.activeAt = activeAt;
    }
}