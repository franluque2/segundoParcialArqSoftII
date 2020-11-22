package ar.edu.ucc.arqSoft.baseService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.ucc.arqSoft.baseService.dao.StateDao;
import ar.edu.ucc.arqSoft.baseService.dto.StateRequestDto;
import ar.edu.ucc.arqSoft.baseService.dto.StateResponseDto;
import ar.edu.ucc.arqSoft.baseService.model.State;
import ar.edu.ucc.arqSoft.common.dto.ModelDtoConverter;
import ar.edu.ucc.arqSoft.common.exception.BadRequestException;
import ar.edu.ucc.arqSoft.common.exception.EntityNotFoundException;

@Service
@Transactional
public class StateService {
	
	@Autowired
	private StateDao stateDao;

	public StateResponseDto getStateById(Long id) throws EntityNotFoundException {
		State state = stateDao.load(id);
				
		StateResponseDto response = (StateResponseDto) new ModelDtoConverter().convertToDto(state, new StateResponseDto());	
		return response;
	}
	
	public List<StateResponseDto> getAllStates() {
		List<State> states = stateDao.getAll();
		
		List<StateResponseDto> response = new ArrayList<StateResponseDto>();
		 
		for (State state : states) {
			response.add((StateResponseDto) new ModelDtoConverter().convertToDto(state, new StateResponseDto()));
		}
		
		return response;
	}
	
	
	public StateResponseDto insertState(StateRequestDto request) throws BadRequestException {
		
		State state = (State) new ModelDtoConverter().convertToEntity(new State(), request);
		
		stateDao.insert(state);
		
		StateResponseDto response = (StateResponseDto) new ModelDtoConverter().convertToDto(state, new StateResponseDto());	
		
		return response;
	}
	
}
