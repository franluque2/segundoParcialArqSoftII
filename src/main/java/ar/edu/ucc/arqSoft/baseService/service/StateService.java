package ar.edu.ucc.arqSoft.baseService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.ucc.arqSoft.baseService.dao.StateDao;
import ar.edu.ucc.arqSoft.baseService.dto.StateRequestDto;
import ar.edu.ucc.arqSoft.baseService.dto.StateResponseDto;
import ar.edu.ucc.arqSoft.baseService.model.State;
import ar.edu.ucc.arqSoft.common.dto.ModelDtoConverter;

@Service
@Transactional
public class StateService {
	
	@Autowired
	private StateDao stateDao;

	public StateResponseDto getStateById(Long id) {
		State state = stateDao.load(id);
		
		
		//StateResponseDto dto = new StateResponseDto();
		//dto.setName(state.getName());
		//return dto;
		
		
		StateResponseDto response = (StateResponseDto) new ModelDtoConverter().convertToDto(state, new StateResponseDto());	
		return response;
	}
	
	
	public StateResponseDto insertState(StateRequestDto request) {
		
		State state = (State) new ModelDtoConverter().convertToEntity(new State(), request);
		
		stateDao.insert(state);
		
		StateResponseDto response = (StateResponseDto) new ModelDtoConverter().convertToDto(state, new StateResponseDto());	
		
		return response;
	}
	
}
