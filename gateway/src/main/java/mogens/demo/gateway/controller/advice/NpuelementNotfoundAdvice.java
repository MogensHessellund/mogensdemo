package mogens.demo.gateway.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import mogens.demo.lib.NpuelementNotfoundException;

@ControllerAdvice
public class NpuelementNotfoundAdvice {

    @ResponseBody
    @ExceptionHandler(NpuelementNotfoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String elementNotFoundHandler(NpuelementNotfoundException ex) {
        return ex.getMessage();
    }   
    
}
