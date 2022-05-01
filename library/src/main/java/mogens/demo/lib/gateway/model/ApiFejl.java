package mogens.demo.lib.gateway.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class ApiFejl {

	Integer fejlkode;
	String fejlbesked;
	Long linie;	
	
	public ApiFejl() {
		super();
	}

	public ApiFejl(Integer fejlkode, String fejlbesked) {
		super();
		this.fejlkode = fejlkode;
		this.fejlbesked = fejlbesked;
	}
	
}
