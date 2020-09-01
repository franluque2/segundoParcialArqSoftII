package ar.edu.ucc.arqSoft.baseService.test.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ar.edu.ucc.arqSoft.baseService.dto.StateRequestDto;
import ar.edu.ucc.arqSoft.baseService.dto.StateResponseDto;
import ar.edu.ucc.arqSoft.baseService.service.StateService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml", "classpath:/spring/applicationContext.xml" })
public class StateServiceTest {
	
	@Autowired
	private StateService stateService;
	
	@Test
	public void testFindById() {
		StateResponseDto response = stateService.getStateById((long) 2);
		
		Assert.assertEquals("Córdoba", response.getName());
		return;
	}
	
	@Test
	public void testInsert() {
		StateRequestDto request = new StateRequestDto();
		request.setName("Catamarca");
		
		StateResponseDto response = stateService.insertState(request);
		
		Assert.assertEquals("Catamarca",response.getName());
		return;
	}
}
