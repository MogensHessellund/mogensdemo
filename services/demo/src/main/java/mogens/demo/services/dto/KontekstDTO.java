package mogens.demo.services.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@Data
@NoArgsConstructor
public class KontekstDTO {
    private long id;

	int version;

	private String createdAt;

	private String bruger;

}
