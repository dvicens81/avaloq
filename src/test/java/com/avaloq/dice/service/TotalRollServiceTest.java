package com.avaloq.dice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.avaloq.dice.convert.DiceEntityToTotalRollDtoConvert;
import com.avaloq.dice.dto.RollDto;
import com.avaloq.dice.entity.DiceEntity;
import com.avaloq.dice.repository.DiceRepository;

@SpringBootTest
public class TotalRollServiceTest {
	
	@InjectMocks
	private TotalRollServiceImpl totalRollService;
	@Mock
	private DiceRepository diceRepository;
	@Mock
	private DiceEntityToTotalRollDtoConvert diceEntityToTotalRollConvert;
	
	@Test
	public void getTotalRoll() {
		List<DiceEntity> listDiceEntity = new ArrayList<>();
		listDiceEntity.add(DiceEntity.builder().numberDice(2).sideDice(4).id(20).build());
		listDiceEntity.add(DiceEntity.builder().numberDice(1).sideDice(6).id(40).build());
		
		List<RollDto> listTotalRoll = new ArrayList<>();
		listTotalRoll.add(RollDto.builder().numberDice(2).sideDice(4).totalRolls(20).build());
		listTotalRoll.add(RollDto.builder().numberDice(1).sideDice(6).totalRolls(40).build());
		
		when(diceRepository.getTotalRollByNumberAndSideDice()).thenReturn(listDiceEntity);
		when(diceEntityToTotalRollConvert.convert(Mockito.any())).thenReturn(listTotalRoll);
		
		List<RollDto> response = totalRollService.getTotalRolls();
		assertEquals(2, response.get(0).getNumberDice());
		assertEquals(1, response.get(1).getNumberDice());
		assertEquals(4, response.get(0).getSideDice());
		assertEquals(6, response.get(1).getSideDice());
		assertEquals(20, response.get(0).getTotalRolls());
		assertEquals(40, response.get(1).getTotalRolls());
	}

}
