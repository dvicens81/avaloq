package com.avaloq.dice.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.avaloq.dice.dto.CodeError;
import com.avaloq.dice.dto.DiceFilter;
import com.avaloq.dice.enums.DiceErrorsEnum;
/**
 * Validator layer for the dice
 * 
 * @author dvicensnoguera
 *
 */
@Component
public class DiceValidator extends DiceAbstractValidator<DiceFilter> {
	
	private static final int MIN_VALUE_NUMBER_DICE = 1;
	private static final int MIN_VALUE_TOTAL_ROLLS = 1;
	private static final int MIN_VALUE_SIDES_DICE = 4;

	@Override
	public List<CodeError> validate(DiceFilter filter) {
		List<CodeError> listErrors = new ArrayList<>();
		//check number of dice
		this.checkAndAddError(listErrors, DiceErrorsEnum.NUMBER_DICE.getCode(), 
											DiceErrorsEnum.NUMBER_DICE.getDescription(),
											MIN_VALUE_NUMBER_DICE, filter.getNumber());
		//check total rolls
		this.checkAndAddError(listErrors, DiceErrorsEnum.TOTAL_ROLLS.getCode(), 
											DiceErrorsEnum.TOTAL_ROLLS.getDescription(),
											MIN_VALUE_TOTAL_ROLLS, filter.getTotalRolls());
		//check number of dice
		this.checkAndAddError(listErrors, DiceErrorsEnum.SIDES_DICE.getCode(), 
											DiceErrorsEnum.SIDES_DICE.getDescription(),
											MIN_VALUE_SIDES_DICE, filter.getSides());
		return listErrors;
	}
	


}
