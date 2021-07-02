package com.avaloq.dice.convert;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.avaloq.dice.dto.RollDto;
import com.avaloq.dice.entity.DiceEntity;


@SpringBootTest
public class DiceEntityToTotalRollDtoConvertTest {
	
	@InjectMocks
	private DiceEntityToTotalRollDtoConvert convert;
	
	@Test
	public void convertTest() {
		List<DiceEntity> list = new ArrayList<>();
		list.add(DiceEntity.builder().numberDice(2).sideDice(4).totalRoll(20).build());
		list.add(DiceEntity.builder().numberDice(1).sideDice(6).totalRoll(40).build());
		
		List<RollDto> response = convert.convert(list);
		assertEquals(2, response.get(0).getNumberDice());
		assertEquals(1, response.get(1).getNumberDice());
		assertEquals(4, response.get(0).getSideDice());
		assertEquals(6, response.get(1).getSideDice());
		assertEquals(20, response.get(0).getTotalRolls());
		assertEquals(40, response.get(1).getTotalRolls());
	}

}
