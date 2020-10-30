package ar.edu.ucc.arqSoft.common.dao;

import java.io.Serializable;
import java.util.List;

import ar.edu.ucc.arqSoft.common.exception.BadRequestException;
import ar.edu.ucc.arqSoft.common.exception.EntityNotFoundException;

public interface GenericDao<E, ID extends Serializable> {
	
	public void insert(E entity) throws BadRequestException;
	
	public void saveOrUpdate(E entity);

	public void update(E entity);

	public void remove(E entity);

	public E load(ID key) throws EntityNotFoundException;

	public List<E> getAll();
	
}
