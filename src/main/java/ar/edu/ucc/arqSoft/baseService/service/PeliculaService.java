package ar.edu.ucc.arqSoft.baseService.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.ucc.arqSoft.baseService.dao.PeliculaDao;
import ar.edu.ucc.arqSoft.baseService.dto.PeliculaResponseDto;
import ar.edu.ucc.arqSoft.baseService.model.Pelicula;
import ar.edu.ucc.arqSoft.common.exception.BadRequestException;
import ar.edu.ucc.arqSoft.common.exception.EntityNotFoundException;

@Service
@Transactional
public class PeliculaService {
	
	
	@Autowired
	private PeliculaDao peliculaDao;
	
	
	public PeliculaResponseDto getPeliculaById (Long id) throws EntityNotFoundException, BadRequestException {
		
		if (id <= 0) {
			throw new BadRequestException();
		}
		
		Pelicula pelicula = peliculaDao.load(id);
		
		PeliculaResponseDto dto = new PeliculaResponseDto();
		dto.setNombre(pelicula.getTitulo());
		dto.setGenero(pelicula.getGenero().toString().toLowerCase());
		
		return dto;
		
	}

}
