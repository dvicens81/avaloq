package com.avaloq.dice.operation;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.avaloq.dice.dto.DiceFilter;
import com.avaloq.dice.map.DiceMapOperations;

@SpringBootTest
public class DiceCompleteRollOperationTest {
	@InjectMocks
	private DiceCompleteRollOperation diceCompleteRoll;
	@Mock
	private DiceSpecificRollOperation diceSpecificRoll;
	@Mock
	private DiceMapOperations diceMap;
	
	@Test
	public void getRollInformationTest() {
		DiceFilter diceFilter = DiceFilter.builder().number(1).totalRolls(1).sides(4).build();
		when(diceSpecificRoll.getTotalOfOneRoll(diceFilter.getNumber(), diceFilter.getSides())).thenReturn(2);
		Map<Integer, Integer> response = diceCompleteRoll.getRollInformation(diceFilter);
		assertNotNull(response);
	}

}
