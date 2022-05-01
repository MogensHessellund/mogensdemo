package cgi.labterm.gateway.controller.advice;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cgi.labterm.lib.ApiException;
import cgi.labterm.lib.gateway.model.ApiResultat;
import lombok.extern.java.Log;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Log
public class ApiExceptionAdvice {

	@ResponseBody
	@ExceptionHandler({ ApiException.class })
	protected ResponseEntity<Object> handleApiFejl(ApiException ex) {
		log.info("ApiExceptionAdvice.handleApiFejl called in gateway");
		ApiResultat resultat = ex.getFejl();
		return buildResponseEntity(resultat);
	}

	private ResponseEntity<Object> buildResponseEntity(ApiResultat resultat) {
		return new ResponseEntity<Object>(resultat, new HttpHeaders(), resultat.getStatus());
	}

	// other exception handlers below

}
