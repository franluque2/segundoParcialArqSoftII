package ar.edu.ucc.arqSoft.segundoParcial.dto;

import java.util.Date;
import java.util.Set;

import ar.edu.ucc.arqSoft.common.dto.DtoEntity;
import ar.edu.ucc.arqSoft.segundoParcial.model.State;
import ar.edu.ucc.arqSoft.segundoParcial.model.Task;
import ar.edu.ucc.arqSoft.segundoParcial.model.User;

public class ProjectRequestDto implements DtoEntity {
	
	private String name;
	
	private String description;
	
	private Date start;
	
	private Date finish;
	
	private State state;
	
	private Set<User> users;
	
	private Set<Task> tasks;

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
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
	
}
