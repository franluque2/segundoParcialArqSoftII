package ar.edu.ucc.arqSoft.segundoParcial.dao;

import org.springframework.stereotype.Repository;

import ar.edu.ucc.arqSoft.common.dao.GenericDaoImp;

import ar.edu.ucc.arqSoft.segundoParcial.model.Task;

@Repository
public class TaskImpDao extends GenericDaoImp<Task, Long> implements TaskDao{

}
