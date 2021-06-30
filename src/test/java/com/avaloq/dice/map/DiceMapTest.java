package com.avaloq.dice.map;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DiceMapTest {
	
	@InjectMocks
	private DiceMap diceMap;
	
	@Test
	public void testMap() {
		Map<Integer, Integer> map = new HashMap<>();		
		diceMap.updateMapInformation(map, 6);
		assertEquals(map.get(6), 1);
		diceMap.updateMapInformation(map, 6);
		assertEquals(map.get(6), 2);
		diceMap.updateMapInformation(map, 5);
		assertEquals(map.get(5), 1);
	}

}
