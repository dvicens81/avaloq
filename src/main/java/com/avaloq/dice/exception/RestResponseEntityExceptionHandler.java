package com.avaloq.dice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Handler class to manage the customize DiceRuntimeException
 * @author dvicensnoguera
 *
 */

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(DiceRuntimeException.class)
	@ResponseBody
	public ResponseEntity<Object> handleDiceRuntimeException(DiceRuntimeException e) {
	    return new ResponseEntity<>(e.getErrors(), HttpStatus.BAD_REQUEST);
	}

}
