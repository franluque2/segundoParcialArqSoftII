package ar.edu.ucc.arqSoft.segundoParcial.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ar.edu.ucc.arqSoft.baseService.model.Alquiler;
import ar.edu.ucc.arqSoft.common.model.GenericObject;
import ar.edu.ucc.arqSoft.segundoParcial.model.Task;


@Entity
@Table(name = "STATE")
public class State extends GenericObject {
	
	@NotNull
	@Size(min = 1, max = 400)
	@Column(name = "NAME")
	private String name;
	
	@NotNull
	@Size(min = 1, max = 500)
	@Column(name = "BODY")
	private String body;
	
	@OneToMany(mappedBy="state", fetch = FetchType.LAZY)
	private Set<Task> tasks;

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

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}
}
