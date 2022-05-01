package cgi.labterm.lib.gateway.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ApiResultat {

	private HttpStatus status = HttpStatus.OK;
	private Date tidspunkt;
	private String besked = "";
	private List<ApiFejl> fejl = new ArrayList<ApiFejl>();

	public ApiResultat() {
		super();
		this.setTidspunkt(new Date());
	}

	public ApiResultat(HttpStatus status, String besked, List<ApiFejl> fejl) {
		super();
		this.setTidspunkt(new Date());
		this.status = status;
		this.besked = besked;
		this.fejl = fejl;
	}

	public ApiResultat(HttpStatus status, String besked, ApiFejl fejl) {
		super();
		this.setTidspunkt(new Date());
		this.status = status;
		this.besked = besked;
		this.fejl = Arrays.asList(fejl);
	}

	public boolean hasErrors() {
		return !this.fejl.isEmpty();
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getBesked() {
		return besked;
	}

	public void setMessage(String besked) {
		this.besked = besked;
	}

	public List<ApiFejl> getFejl() {
		return fejl;
	}

	public void setFejl(List<ApiFejl> fejl) {
		this.fejl = fejl;
	}

	public Date getTidspunkt() {
		return tidspunkt;
	}

	public void setTidspunkt(Date tidspunkt) {
		this.tidspunkt = tidspunkt;
	}

	public void tilfoej(ApiResultat nyeFejl) {
		// Nyeste vinder - tilføjes hvis den indeholder noget - gælder for alle
		// attributter
		if (nyeFejl != null && nyeFejl.fejl != null && !nyeFejl.fejl.isEmpty()) {
			this.fejl.addAll(nyeFejl.fejl);

			// Sæt status til BAD_REQUEST hvis den var ok
			if (this.status == HttpStatus.OK) {
				this.status = HttpStatus.BAD_REQUEST;
			}

			// Overskriv hvis der var fejl
			if (nyeFejl.besked != null && !nyeFejl.besked.isEmpty()) {
				this.setMessage(nyeFejl.besked);
			}

			// Overskriv hvis der var fejl
			if (nyeFejl.status != null) {
				this.setStatus(nyeFejl.status);
			}
		}
	}

	public void tilfoejFejl(ApiFejl fejl) {
		this.fejl.add(fejl);

		// Sæt status til BAD_REQUEST hvis den var ok
		if (this.status == HttpStatus.OK) {
			this.status = HttpStatus.BAD_REQUEST;
		}
	}
	
	public void tilfoejFejl(ApiResultat fejlListe) {
		if (fejlListe != null && fejlListe.fejl != null && !fejlListe.fejl.isEmpty()) {

			this.fejl.addAll(fejlListe.getFejl());

			// Sæt status til BAD_REQUEST hvis den var ok
			if (this.status == HttpStatus.OK) {
				this.status = HttpStatus.BAD_REQUEST;
			}

			// Overskriv hvis der var fejl
			if (fejlListe.besked != null && !fejlListe.besked.isEmpty()) {
				this.setMessage(fejlListe.besked);
			}

			// Overskriv hvis der var fejl
			if (fejlListe.status != null) {
				this.setStatus(fejlListe.status);
			}
		}
	}
}
