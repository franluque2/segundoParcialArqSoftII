package ar.edu.ucc.arqSoft.baseService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.ucc.arqSoft.baseService.dao.PeliculaDao;
import ar.edu.ucc.arqSoft.baseService.dto.PeliculaResponseDto;
import ar.edu.ucc.arqSoft.baseService.model.Pelicula;

@Service
@Transactional
public class PeliculaService {
	
	
	@Autowired
	private PeliculaDao peliculaDao;
	
	
	public PeliculaResponseDto getPeliculaById (Long id) {
		
		Pelicula pelicula = peliculaDao.load(id);
		
		PeliculaResponseDto dto = new PeliculaResponseDto();
		dto.setNombre(pelicula.getTitulo());
		
		return dto;
		
	}

}
