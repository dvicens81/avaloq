package com.avaloq.dice.convert;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.avaloq.dice.dto.DiceFilter;
import com.avaloq.dice.entity.DiceEntity;


@SpringBootTest
public class DiceFilterToDiceEntityConvertTest {
	
	@InjectMocks
	private DiceFilterToDiceEntityConvert convert;
	
	@Test
	public void convertTest() {
		DiceFilter filter = DiceFilter.builder().number(2).sides(4).totalRolls(20).build();
		
		DiceEntity response = convert.convert(filter);
		assertEquals(2, response.getNumberDice());
		assertEquals(4, response.getSideDice());
		assertEquals(20, response.getTotalRoll());
	}

}
