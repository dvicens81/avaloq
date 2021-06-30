package com.avaloq.dice.validate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.avaloq.dice.dto.CodeError;
import com.avaloq.dice.dto.DiceFilter;
import com.avaloq.dice.exception.DiceRuntimeException;
import com.avaloq.dice.validator.DiceValidator;

@SpringBootTest
public class DiceValidateFormTest {
	
	@InjectMocks
	private DiceValidateForm validateForm;
	
	@Mock
	private DiceValidator validator;
	
	@Test
	public void testValidateForm() {
		DiceFilter diceFilter = new DiceFilter();
		
		when(validator.validate(diceFilter)).thenReturn(new ArrayList<>());
		
		List<CodeError> errors = validateForm.validateInformation(diceFilter);
		assertEquals(0, errors.size());
	}
	@Test
	public void testValidateFormRuntimeException() {
		DiceFilter diceFilter = new DiceFilter();
		List<CodeError> codeError = new ArrayList<>();
		codeError.add(CodeError.builder().code(5).description("empty").build());
		when(validator.validate(diceFilter)).thenReturn(codeError);
		Assertions.assertThrows(DiceRuntimeException.class, () -> {
				validateForm.validateInformation(diceFilter);
		});
	}
}
