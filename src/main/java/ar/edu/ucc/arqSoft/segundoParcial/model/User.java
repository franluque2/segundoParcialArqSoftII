package ar.edu.ucc.arqSoft.segundoParcial.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ar.edu.ucc.arqSoft.common.model.GenericObject;

@Entity
@Table(name = "USER")
public class User extends GenericObject {

	
	
	@ManyToMany(cascade = { CascadeType.ALL })
	 @JoinTable(
	   name="USER_PROJECT",
	   joinColumns=@JoinColumn(name="USER_ID"),
	   inverseJoinColumns=@JoinColumn(name="PROJECT_ID"))
	public Set<Project> projects = new HashSet<Project>();
	
	public Set<Project> getProjects(){return projects;};

	@NotNull
	@Size(min = 1, max = 400)
	@Column(name = "NAME")
	private String name;
	
	@NotNull
	@Size(min = 1, max = 400)
	@Column(name = "LASTNAME")
	private String lastName;
	
	@NotNull
	@Size(min = 1, max = 400)
	@Column(name = "ADRESSS")
	private String adress;
	
	@NotNull
	@Size(min = 1, max = 400)
	@Column(name = "EMAIL")
	private String email;
	
	@NotNull
	@Column(name = "PHONE")
	private int phone;
	
	@NotNull
	@Column(name = "DNI")
	private int DNI;
	
	@NotNull
	@Column(name = "INSCRIPTION")
	private Date inscription;
	
	@NotNull
	@Column(name = "BIRTHDAY")
	private Date birthday;
	
	@NotNull
	@Size(min = 1, max = 400)
	@Column(name = "USERNAME")
	private String username;
	
	@NotNull
	@Size(min = 1, max = 400)
	@Column(name = "PASSWORD")
	private String password;
	
	@NotNull
	@Size(min = 1, max =  400)
	@Column(name = "PERMITS")
	private String permits;
	
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

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
	
	public void addProject(Project project) {
		this.projects.add(project);	
	}
}
