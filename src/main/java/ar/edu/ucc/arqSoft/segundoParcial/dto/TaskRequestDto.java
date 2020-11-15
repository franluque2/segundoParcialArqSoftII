package ar.edu.ucc.arqSoft.segundoParcial.dto;

import ar.edu.ucc.arqSoft.common.dto.DtoEntity;

public class TaskRequestDto implements DtoEntity {

	private String taskName;
	
	private Long userId;
	
	private Long projectId;
	
	private Long stateId;
	private String Body;
	
	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public String getBody() {
		return Body;
	}

	public void setBody(String body) {
		Body = body;
	}	
}
