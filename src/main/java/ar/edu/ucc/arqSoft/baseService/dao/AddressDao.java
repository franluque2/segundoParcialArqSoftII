package ar.edu.ucc.arqSoft.baseService.dao;

import java.util.List;

import ar.edu.ucc.arqSoft.baseService.model.Address;
import ar.edu.ucc.arqSoft.common.dao.GenericDao;

public interface AddressDao extends GenericDao<Address, Long> {

	public List<Address> findByStreet(String street);

}
