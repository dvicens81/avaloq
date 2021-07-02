package com.avaloq.dice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.avaloq.dice.controller.v1.RollController;
import com.avaloq.dice.dto.RollDto;
import com.avaloq.dice.service.RollService;

@SpringBootTest
public class RollControllerTest {
	@InjectMocks
	private RollController rollController;
	@Mock
	private RollService totalRollService;
	
	@Test
	public void getRollInformation() {
		  MockHttpServletRequest request = new MockHttpServletRequest();
		  RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		  
		  List<RollDto> listTotalRoll = new ArrayList<>();
		  listTotalRoll.add(RollDto.builder().numberDice(2).sideDice(4).totalRolls(20).build());
		  listTotalRoll.add(RollDto.builder().numberDice(1).sideDice(6).totalRolls(40).build());
			
		  when(totalRollService.getTotalRolls()).thenReturn(listTotalRoll);
		  
		  ResponseEntity<List<RollDto>> response = rollController.getTotalRolls();
		  assertEquals(2, response.getBody().get(0).getNumberDice());
		  assertEquals(1, response.getBody().get(1).getNumberDice());
		  assertEquals(4, response.getBody().get(0).getSideDice());
		  assertEquals(6, response.getBody().get(1).getSideDice());
		  assertEquals(20, response.getBody().get(0).getTotalRolls());
		  assertEquals(40, response.getBody().get(1).getTotalRolls());
	}
}
