package com.avaloq.dice.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.avaloq.dice.dto.CodeError;
import com.avaloq.dice.dto.DiceFilter;
import com.avaloq.dice.enums.DiceErrorsEnum;

@SpringBootTest
public class DiceValidatorTest {
	
	@InjectMocks
	private DiceValidator validator;
	
	@Test
	public void validatorEmptyListTest() {
		DiceFilter diceFilter = new DiceFilter();
		List<CodeError> errors = validator.validate(diceFilter);
		assertEquals(0, errors.size());
	}
	
	@Test
	public void validator_Number_Dice_ErrorTest() {
		DiceFilter diceFilter = DiceFilter.builder().number(0).sides(5).totalRolls(4).build();
		List<CodeError> errors = validator.validate(diceFilter);
		assertEquals(1, errors.size());
		assertEquals(DiceErrorsEnum.NUMBER_DICE.getCode(), errors.get(0).getCode());
	}
	
	@Test
	public void validator_Total_Rolls_ErrorTest() {
		DiceFilter diceFilter = DiceFilter.builder().number(1).sides(5).totalRolls(0).build();
		List<CodeError> errors = validator.validate(diceFilter);
		assertEquals(1, errors.size());
		assertEquals(DiceErrorsEnum.TOTAL_ROLLS.getCode(), errors.get(0).getCode());
	}
	
	@Test
	public void validator_Sides_ErrorTest() {
		DiceFilter diceFilter = DiceFilter.builder().number(1).sides(3).totalRolls(1).build();
		List<CodeError> errors = validator.validate(diceFilter);
		assertEquals(1, errors.size());
		assertEquals(DiceErrorsEnum.SIDES_DICE.getCode(), errors.get(0).getCode());
	}

}
