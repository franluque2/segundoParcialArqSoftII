package ar.edu.ucc.arqSoft.segundoParcial.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ar.edu.ucc.arqSoft.common.model.GenericObject;

@Entity
@Table(name = "PROJECT")
public class Project extends GenericObject {

	@ManyToMany(mappedBy = "projects")
	private Set<User> users;
	
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
	private Set<Task> tasks;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="STATE_ID")
	private State state;

	@NotNull
	@Size(min = 1, max = 400)
	@Column(name = "NAME")
	private String name;
	
	@NotNull
	@Size(min = 10, max = 5000)
	@Column(name = "DESCRIPTION")
	private String description;
	
	@NotNull
	@Column(name = "START")
	private Date start;
	
	@Column(name = "FINISH")
	private Date finish;
	
	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Set<User> getUsers() {
		return users;
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

	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
