package ar.edu.ucc.arqSoft.segundoParcial.dto;

import ar.edu.ucc.arqSoft.common.dto.DtoEntity;

public class TaskChangeRequestDto implements DtoEntity {

	private Long userId;
	
	private Long taskId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

}
