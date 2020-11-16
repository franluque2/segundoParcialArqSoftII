package ar.edu.ucc.arqSoft.segundoParcial.dao;

import org.springframework.stereotype.Repository;

import ar.edu.ucc.arqSoft.common.dao.GenericDaoImp;
import ar.edu.ucc.arqSoft.segundoParcial.model.User;

@Repository
public class UserImpDao extends GenericDaoImp<User, Long> implements UserDao{

}
