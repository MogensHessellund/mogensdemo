package mogens.demo.services.entities.brugsnavn;

import mogens.demo.services.dto.BrugsnavnDTO;
import mogens.demo.services.entities.base.Kontekst;
import org.hibernate.envers.Audited;

import javax.persistence.*;

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