package ar.edu.ucc.arqSoft.baseService.dao;

import java.util.List;

import ar.edu.ucc.arqSoft.baseService.model.User;
import ar.edu.ucc.arqSoft.common.dao.GenericDao;

public interface UserDao extends GenericDao<User, Long> {
    
    public List<User> findByName(String name);
}
