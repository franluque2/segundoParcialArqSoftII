package ar.edu.ucc.arqSoft.segundoParcial.dto;

import java.util.Date;
import java.util.Set;

import ar.edu.ucc.arqSoft.common.dto.DtoEntity;
import ar.edu.ucc.arqSoft.segundoParcial.model.Comment;
import ar.edu.ucc.arqSoft.segundoParcial.model.State;

public class TaskResponseDto implements DtoEntity {
	// setName setUser setProject setDate
	
	private String name;
	
	private Long userId;
	
	private Long projectId;
	
	private Date dateStart;
	
	private String body;
	
	private State state;
	
	private Date dateEnd;
	
	private Set<Comment> comments;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Date getDate() {
		return dateStart;
	}

	public void setDate(Date date) {
		this.dateStart = date;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateend) {
		this.dateEnd = dateend;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
}
