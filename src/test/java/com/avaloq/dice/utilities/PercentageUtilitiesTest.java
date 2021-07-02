package com.avaloq.dice.utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.avaloq.dice.entity.RollEntity;

@SpringBootTest
public class PercentageUtilitiesTest {
	
	@InjectMocks
	private PercentageUtilities percentageUtilities;
	
	@Test
	public void getPercentageTest() {
		String response = percentageUtilities.getPercentage(20, 3);
		assertEquals("15.0", response);
	}
	
	@Test
	public void getPercentageLessTest() {
		String response = percentageUtilities.getPercentage(50, 1);
		assertEquals("2.0", response);
	}
	
	@Test
	public void getTotalFromListRollsTest() {
		List<RollEntity> listRolls = new ArrayList<>();
		listRolls.add(RollEntity.builder().number(2).sideDice(4).total(20).numberDice(2).build());
		listRolls.add(RollEntity.builder().number(3).sideDice(4).total(10).numberDice(2).build());
		
		int response = percentageUtilities.getTotalFromListRolls(listRolls);
		assertEquals(30, response);
	}

}
