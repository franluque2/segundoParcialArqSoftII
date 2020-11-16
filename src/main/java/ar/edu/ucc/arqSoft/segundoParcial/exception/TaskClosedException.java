package ar.edu.ucc.arqSoft.segundoParcial.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class TaskClosedException extends Exception {

	private static final long serialVersionUID = 2L;

}
