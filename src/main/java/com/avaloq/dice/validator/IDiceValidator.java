package com.avaloq.dice.validator;

import java.util.List;

import com.avaloq.dice.dto.CodeError;

public interface IDiceValidator<T> {
	
	List<CodeError> validate(T dto);

}
