package ar.edu.ucc.arqSoft.baseService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ar.edu.ucc.arqSoft.common.model.GenericObject;

@Entity
@Table(name = "ADDRESS")
public class Address extends GenericObject {
	
	@NotNull
	@Size(min = 1, max = 250)
	@Column(name = "STREET")
	private String street;

	@NotNull
	@Column(name = "NUMBER")
	private Long number;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="STATE_ID")
	private State state;

	@Enumerated(value = EnumType.ORDINAL)
	@Column(name = "ADDRESS_TYPE")
	private AddressType addressType;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="USER_ID")
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public AddressType getAddressType() {
		return addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}

}
