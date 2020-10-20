package ar.edu.ucc.arqSoft.baseService.dao;

import org.springframework.stereotype.Repository;

import ar.edu.ucc.arqSoft.baseService.model.Socio;
import ar.edu.ucc.arqSoft.common.dao.GenericDaoImp;

@Repository
public class SocioImpDao extends GenericDaoImp<Socio, Long> implements SocioDao{

}
