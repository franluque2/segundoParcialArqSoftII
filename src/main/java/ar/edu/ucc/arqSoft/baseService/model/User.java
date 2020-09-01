package ar.edu.ucc.arqSoft.baseService.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ar.edu.ucc.arqSoft.common.model.GenericObject;

@Entity
@Table(name = "USER")
public class User extends GenericObject{
	
	@NotNull
	@Size(min = 1, max = 250)
	@Column(name = "NAME")
	private String name;
	
	@NotNull
	@Size(min = 1, max = 250)
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@NotNull
	@Size(min = 1, max = 500)
	@Column(name = "EMAIL")
	private String email;
	
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	private Set<Address> addresses;

	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
	
	

}
