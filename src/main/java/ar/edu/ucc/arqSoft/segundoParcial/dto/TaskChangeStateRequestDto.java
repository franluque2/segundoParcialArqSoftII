package ar.edu.ucc.arqSoft.segundoParcial.dto;

import ar.edu.ucc.arqSoft.common.dto.DtoEntity;

public class TaskChangeStateRequestDto implements DtoEntity {

	private Long stateId;
	
	private Long taskId;


	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

}
