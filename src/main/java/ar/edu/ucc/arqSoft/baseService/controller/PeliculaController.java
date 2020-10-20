package ar.edu.ucc.arqSoft.baseService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.edu.ucc.arqSoft.baseService.dto.PeliculaResponseDto;
import ar.edu.ucc.arqSoft.baseService.service.PeliculaService;

@Controller
@RequestMapping("/pelicula")
public class PeliculaController {
	
	
	@Autowired
	private PeliculaService peliculaService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody PeliculaResponseDto lookupPeliculaById(@PathVariable("id") Long id)
    {
        return peliculaService.getPeliculaById(id);
    }

}
