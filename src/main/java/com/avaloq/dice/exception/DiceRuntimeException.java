package com.avaloq.dice.exception;

import java.util.List;

import com.avaloq.dice.dto.CodeError;
/**
 * Customize runtimeException 
 * Contains list of CodeError
 * @author dvicensnoguera
 *
 */
public class DiceRuntimeException extends RuntimeException {	
	private static final long serialVersionUID = 6511959340825334759L;
	
	private final List<CodeError> errors;
	
	public DiceRuntimeException(List<CodeError> errors) {
        super();
        this.errors = errors;
    }
	
	public List<CodeError> getErrors() {
        return errors;
    }

}
