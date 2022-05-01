package mogens.demo.services.entities;

import mogens.demo.services.entities.base.Kontekst;

import javax.persistence.*;

@Table(name = "element")
@Entity
public class Element extends Kontekst {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}