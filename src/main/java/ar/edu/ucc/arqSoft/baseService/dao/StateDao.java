package ar.edu.ucc.arqSoft.baseService.dao;

import java.util.List;

import ar.edu.ucc.arqSoft.baseService.model.State;
import ar.edu.ucc.arqSoft.common.dao.GenericDao;

public interface StateDao extends GenericDao<State, Long> {
	    
    public List<State> findByName(String name);

}
