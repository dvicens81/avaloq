package com.avaloq.dice.convert;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.avaloq.dice.dto.RelativeDto;
import com.avaloq.dice.entity.RollEntity;
import com.avaloq.dice.utilities.PercentageUtilities;

@SpringBootTest
public class ListRollEntityToRelativeDtoConvertTest {
	
	@InjectMocks
	private ListRollEntityToRelativeDtoConvert convert;
	
	@Mock
	private PercentageUtilities percentageUtilities;
	
	@Test
	public void convertTest() {
		List<RollEntity> listRolls = new ArrayList<>();
		listRolls.add(RollEntity.builder().number(2).sideDice(4).total(20).numberDice(2).build());
		listRolls.add(RollEntity.builder().number(3).sideDice(4).total(10).numberDice(2).build());
		
		when(percentageUtilities.getTotalFromListRolls(listRolls)).thenReturn(30);
		when(percentageUtilities.getPercentage(Mockito.anyInt(), Mockito.anyInt())).thenReturn("5");
		
		RelativeDto relativeDto = convert.convert(listRolls); 
		assertEquals(30, relativeDto.getRoll().getTotalRolls());
		assertEquals(2, relativeDto.getRoll().getNumberDice());
	}

}
