package com.avaloq.dice.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.avaloq.dice.dto.DiceFilter;
import com.avaloq.dice.map.DiceMap;
import com.avaloq.dice.operation.DiceCompleteRollOperation;
import com.avaloq.dice.operation.DiceSpecificRollOperation;

@SpringBootTest
public class DiceCompleteRollOperationTest {
	@InjectMocks
	private DiceCompleteRollOperation diceCompleteRoll;
	@Mock
	private DiceSpecificRollOperation diceSpecificRoll;
	@Mock
	private DiceMap diceMap;
	
	@Test
	public void getRollInformationTest() {
		DiceFilter diceFilter = DiceFilter.builder().number(1).totalRolls(1).sides(4).build();
		when(diceSpecificRoll.getTotalOfOneRoll(diceFilter.getNumber(), diceFilter.getSides())).thenReturn(2);
		doNothing().when(diceMap).updateMapInformation(Mockito.any(), Mockito.any());
		Map<Integer, Integer> response = diceCompleteRoll.getRollInformation(diceFilter);
		assertNotNull(response);
	}

}
