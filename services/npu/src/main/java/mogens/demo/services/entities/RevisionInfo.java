package mogens.demo.services.entities;

import lombok.Getter;
import org.springframework.data.annotation.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "revinfo")
@Immutable
@Entity
@Getter
public class RevisionInfo implements Serializable {
    @Id
    private Long rev;

    @Column
    private Long revtstmp;
}