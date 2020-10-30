package ar.edu.ucc.arqSoft.baseService.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.ucc.arqSoft.baseService.dao.AlquilerDao;
import ar.edu.ucc.arqSoft.baseService.dao.PeliculaDao;
import ar.edu.ucc.arqSoft.baseService.dao.SocioDao;
import ar.edu.ucc.arqSoft.baseService.dto.AlquilerRequestDto;
import ar.edu.ucc.arqSoft.baseService.dto.AlquilerResponseDto;
import ar.edu.ucc.arqSoft.baseService.model.Alquiler;
import ar.edu.ucc.arqSoft.common.exception.EntityNotFoundException;

@Service
@Transactional
public class AlquilerService {
	
	@Autowired
	private AlquilerDao alquilerDao;
	
	@Autowired
	private PeliculaDao peliculaDao;
	
	@Autowired
	private SocioDao socioDao;
	
	
	public AlquilerResponseDto registrarAlquiler (AlquilerRequestDto dto) throws EntityNotFoundException {
		
		Alquiler alquiler = new Alquiler();
		
		alquiler.setFechaAlquiler(Calendar.getInstance().getTime());
		alquiler.setPelicula(peliculaDao.load(dto.getPeliculaId()));
		alquiler.setSocio(socioDao.load(dto.getSocioId()));
		
		
		alquilerDao.insert(alquiler);
		
		AlquilerResponseDto response = new AlquilerResponseDto();
		
		response.setApellido(alquiler.getSocio().getApellido());
		response.setTitulo(alquiler.getPelicula().getTitulo());
		response.setFecha(alquiler.getFechaAlquiler());
		
		// Mail try catch
		
		return response;
		
	}
	

	
}
