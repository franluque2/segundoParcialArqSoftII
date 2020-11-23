package ar.edu.ucc.arqSoft.segundoParcial.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import ar.edu.ucc.arqSoft.common.dto.DtoEntity;
import ar.edu.ucc.arqSoft.segundoParcial.model.Project;
import ar.edu.ucc.arqSoft.segundoParcial.model.Task;

public class UserResponseDto implements DtoEntity {
	
	private String name;
	
	private String lastName;
	
	private String adress;
	
	private String email;
	
	private int phone;
	
	private int DNI;
	
	private Date inscription;
	
	private Date birthday;
	
	private String username;
	
	private String password;
	
	private String permits;
	
	private Set<ProjectResponseDto> projects = new HashSet<ProjectResponseDto>();
	
	public Set<ProjectResponseDto> getProjects() {
		return projects;
	}

	public void setProjects(Set<ProjectResponseDto> projects) {
		this.projects = projects;
	}
	
	public void addProject (Project project) {
		
		ProjectResponseDto dto = new ProjectResponseDto();
		dto.setName(project.getName());
		dto.setDescription(project.getDescription());
		dto.setStart(project.getStart());
		dto.setFinish(project.getFinish());
		dto.setStateId(project.getState().getId());
		//addTasks
		if(!project.getTasks().isEmpty()) {
			for(Task task : project.getTasks()) {
			dto.addTask(task);			
		}
		}
		this.projects.add(dto);
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getDNI() {
		return DNI;
	}

	public void setDNI(int dNI) {
		DNI = dNI;
	}

	public Date getInscription() {
		return inscription;
	}

	public void setInscription(Date inscription) {
		this.inscription = inscription;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPermits() {
		return permits;
	}

	public void setPermits(String permits) {
		this.permits = permits;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}
}