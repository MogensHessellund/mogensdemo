package cgi.labterm.services.npu.entities.brugsnavn;

import cgi.labterm.lib.npu.ViewEnum;
import cgi.labterm.services.npu.dto.BrugsnavnDTO;
import cgi.labterm.services.npu.entities.base.Kontekst;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import javax.persistence.*;
import java.time.LocalDate;

@Audited
@Table(name = "brugsnavn")
@Entity
public class Brugsnavn extends Kontekst {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "npu_element_generator")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String term;

    @Column
    private String type;

    /*
    @Enumerated(EnumType.STRING)
    @Column(name = "sprog", nullable = false)
    private Sprog sprog;
*/

    // Business Methods
    public static Brugsnavn createBrugsnavn(BrugsnavnDTO dto) {
        var brugsnavn = new Brugsnavn();
        return brugsnavn;
    }

}