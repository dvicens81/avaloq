package com.avaloq.dice.service;

import java.util.List;

import com.avaloq.dice.dto.DiceDto;
import com.avaloq.dice.dto.DiceFilter;

public interface DiceService {
	
	List<DiceDto> getRoll(DiceFilter diceFilter);
}
