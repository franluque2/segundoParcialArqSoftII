package ar.edu.ucc.arqSoft.baseService.dao;

import org.springframework.stereotype.Repository;

import ar.edu.ucc.arqSoft.baseService.model.Pelicula;
import ar.edu.ucc.arqSoft.common.dao.GenericDaoImp;

@Repository
public class PeliculaImpDao extends GenericDaoImp<Pelicula, Long> implements PeliculaDao {

}
