package com.avaloq.dice.operation;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.avaloq.dice.operation.DiceSpecificRollOperation;

@SpringBootTest
public class DiceSpecificRollOperationTest {
	
	@InjectMocks
	private DiceSpecificRollOperation rollUtilites;

	@Test
	public void rollDiceTest() {
		int rollNumber = rollUtilites.getTotalOfOneRoll(3, 6);
		assertFalse(rollNumber > 18);
		assertFalse(rollNumber < 2);
	}
	
	@Test
	public void rollDiceOneDiceTest() {
		int rollNumber = rollUtilites.getTotalOfOneRoll(1, 5);
		assertFalse(rollNumber > 6);
		assertFalse(rollNumber < 0);
	}
}
