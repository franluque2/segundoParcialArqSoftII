package ar.edu.ucc.arqSoft.segundoParcial.dao;

import org.springframework.stereotype.Repository;

import ar.edu.ucc.arqSoft.common.dao.GenericDaoImp;

import ar.edu.ucc.arqSoft.segundoParcial.model.Project;

@Repository
public class ProjectImpDao extends GenericDaoImp<Project, Long> implements ProjectDao{

}

