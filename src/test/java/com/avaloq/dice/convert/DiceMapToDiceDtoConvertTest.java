package com.avaloq.dice.convert;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.avaloq.dice.dto.DiceDto;

@SpringBootTest
public class DiceMapToDiceDtoConvertTest {
	
	@InjectMocks
	private DiceMapToDiceDtoConvert convert;
	
	@Test
	public void testConvert() {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(2, 4);
		map.put(5, 6);
		map.put(7, 3);
		
		List<DiceDto> response = convert.convert(map);
		assertEquals(2, response.get(0).getNumber());
		assertEquals(5, response.get(1).getNumber());
		assertEquals(7, response.get(2).getNumber());
		assertEquals(4, response.get(0).getTimes());
		assertEquals(6, response.get(1).getTimes());
		assertEquals(3, response.get(2).getTimes());
	}

}
