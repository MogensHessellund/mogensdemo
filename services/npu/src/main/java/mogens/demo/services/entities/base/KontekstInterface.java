package mogens.demo.services.entities.base;


import java.sql.Timestamp;
import java.time.LocalDate;

public interface KontekstInterface {

    Integer getVersion();

    LocalDate getVirkningFra();

    Timestamp getCreatedAt();

    Timestamp getUpdatedAt();

    Timestamp getActiveAt();

    String getBrugernavn();

    Long getId();
}
