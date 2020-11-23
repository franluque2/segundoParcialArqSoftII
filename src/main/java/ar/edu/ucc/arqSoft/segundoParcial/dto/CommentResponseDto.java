package ar.edu.ucc.arqSoft.segundoParcial.dto;

import java.util.Date;

import ar.edu.ucc.arqSoft.common.dto.DtoEntity;

public class CommentResponseDto implements DtoEntity {
	private String name;
	private String body;
	private Long userId;
	private Long taskId;
	private Date date;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
