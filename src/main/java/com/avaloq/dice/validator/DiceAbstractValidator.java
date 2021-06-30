package com.avaloq.dice.validator;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.apache.commons.lang3.BooleanUtils;

import com.avaloq.dice.dto.CodeError;

/**
 * Abstract class 
 * Implements the interface to the children classes override the method
 * Expose common methods to validate the parameters filled
 * 
 * @author dvicensnoguera
 *
 * @param <T>
 */
public abstract class DiceAbstractValidator<T> implements IDiceValidator<T> {	
	
	/**
	 * check if the parameters are correct
	 * 
	 * @param errors : list to add the errors
	 * @param codeError : codeError on case that the parameter is incorrect
	 * @param description : descriptionError on case that the parameter is incorrect
	 * @param minValue : minValue that the parameter needs to be correct
	 * @param filled : the parameter informed
	 */
	protected void checkAndAddError(List<CodeError> errors, int codeError, String description, int minValue, int filled) {
		boolean isCorrect = validateInt(minValue, filled);
		CodeError error = checkIfIsCorrect(isCorrect, codeError, description);
		addErrorOnList(errors, error);
	}
	
	private boolean validateInt(int minValue, int filled) {
		return Optional.of(filled).filter(f -> f >= minValue ).map(f -> Boolean.TRUE).orElse(Boolean.FALSE);
	}
	
	private CodeError checkIfIsCorrect(boolean isCorrect, int codeError, String description) {
		return Optional.of(isCorrect)
				.filter(BooleanUtils::isFalse)
				.map(bool-> CodeError.builder().code(codeError).description(description).build())
				.orElse(null);
	}
	
	private void addErrorOnList(List<CodeError> errors, CodeError codeError) {
		Optional.ofNullable(codeError)
				.filter(Objects::nonNull)
				.ifPresent(error-> errors.add(codeError));
	}
}
