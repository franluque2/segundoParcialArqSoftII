package ar.edu.ucc.arqSoft.segundoParcial.dto;

import ar.edu.ucc.arqSoft.common.dto.DtoEntity;

public class UserAddProjectDto implements DtoEntity {
	
	private Long userId;
	
	private Long projectId;

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
	
	
}
