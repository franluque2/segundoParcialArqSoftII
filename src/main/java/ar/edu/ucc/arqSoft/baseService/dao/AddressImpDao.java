package ar.edu.ucc.arqSoft.baseService.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import ar.edu.ucc.arqSoft.baseService.model.Address;
import ar.edu.ucc.arqSoft.common.dao.GenericDaoImp;

@Repository
public class AddressImpDao extends GenericDaoImp<Address, Long> implements AddressDao{

	@Override
	public List<Address> findByStreet(String street) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Address> criteria = builder.createQuery(Address.class);
        Root<Address> entity = criteria.from(Address.class);

        criteria.select(entity).where(builder.equal(entity.get("street"), street));
        return em.createQuery(criteria).getResultList();
	}
}
