package com.avaloq.dice.validate;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.avaloq.dice.dto.CodeError;
import com.avaloq.dice.dto.DiceFilter;
import com.avaloq.dice.exception.DiceRuntimeException;
import com.avaloq.dice.validator.DiceValidator;

import lombok.AllArgsConstructor;

/**
 * Validate the fields that are correct.
 * This class dispatch to validator layer 
 * and if the error list is empty then continue 
 * else throw an error an stop the execution
 * @author dvicensnoguera
 *
 */
@Component
@AllArgsConstructor
public class DiceValidateForm {
	
	private final DiceValidator validator;
	
	public List<CodeError> validateInformation(DiceFilter diceFilter) {
		List<CodeError> errors = validator.validate(diceFilter);
		return Optional.of(errors).filter(CollectionUtils::isEmpty).orElseThrow(()->new DiceRuntimeException(errors));
	}

}
