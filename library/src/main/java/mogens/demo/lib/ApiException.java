package mogens.demo.lib;

import mogens.demo.lib.gateway.model.ApiFejl;
import mogens.demo.lib.gateway.model.ApiResultat;

public class ApiException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	ApiResultat fejl;
	
    public ApiException(ApiResultat fejl) {
        super();
        this.fejl = fejl;
    }

    public ApiException(int statusKode, String fejlbesked) {
        super();
        
        this.fejl = new ApiResultat();      
        this.fejl.tilfoejFejl(new ApiFejl(statusKode, fejlbesked));
    }

    public ApiException(ApiFejl fejl) {
        super();
        
        this.fejl = new ApiResultat();      
        this.fejl.tilfoejFejl(fejl);
    }
    
    
    public ApiResultat getFejl() {
		return fejl;
	}

	public void setFejl(ApiResultat fejl) {
		this.fejl = fejl;
	}
    
    
}
