package cgi.labterm.services.npu.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@Data
@NoArgsConstructor
public class KontekstDTO {
	
    private long id;

	int version;

	private String updatedAt;

	private String createdAt;

	private String virkningFra;

	private String activeAt;

	private String bruger;

	private String status;
    int fejlkode;
    private String fejltekst;

    public boolean hasFejl() {
        return fejlkode > 0;
    }

}
