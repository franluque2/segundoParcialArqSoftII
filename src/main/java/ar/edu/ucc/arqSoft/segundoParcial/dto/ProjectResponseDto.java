package ar.edu.ucc.arqSoft.segundoParcial.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import ar.edu.ucc.arqSoft.common.dto.DtoEntity;
import ar.edu.ucc.arqSoft.segundoParcial.model.Comment;
import ar.edu.ucc.arqSoft.segundoParcial.model.Task;
import ar.edu.ucc.arqSoft.segundoParcial.model.User;


public class ProjectResponseDto implements DtoEntity {
	
	private String name;
	
	private String description;
	
	private Date start;
	
	private Date finish;
	
	private Set<UserResponseDto> users = new HashSet<UserResponseDto>();
	
	private Set<TaskResponseDto> tasks = new HashSet<TaskResponseDto>();
	
	private Long stateId;

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public Set<UserResponseDto> getUsers() {
		return users;
	}

	public void setUsers(Set<UserResponseDto> users) {
		this.users = users;
	}

	public Set<TaskResponseDto> getTasks() {
		return tasks;
	}

	public void setTasks(Set<TaskResponseDto> tasks) {
		this.tasks = tasks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getFinish() {
		return finish;
	}

	public void setFinish(Date finish) {
		this.finish = finish;
	}
	
	public void addTask(Task task) {
		
		TaskResponseDto taskDto = new TaskResponseDto();
		taskDto.setBody(task.getBody());
		taskDto.setName(task.getName());
		taskDto.setUserId(task.getUser().getId());
		taskDto.setState(task.getState().getId());
		taskDto.setProjectId(task.getProject().getId());
		taskDto.setDateStart(task.getDateStart());
		taskDto.setDateEnd(task.getDateEnd());
		
		if(!task.getComments().isEmpty()) {
			for(Comment comment : task.getComments()) {
				taskDto.addComments(comment);
			}
		}
		
		this.tasks.add(taskDto);
	}

	public void addUser(User user) {
		UserResponseDto userDto = new UserResponseDto();
		
		userDto.setName(user.getName());

		this.users.add(userDto);
}
}
