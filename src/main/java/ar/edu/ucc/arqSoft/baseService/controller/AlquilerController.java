package ar.edu.ucc.arqSoft.baseService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ar.edu.ucc.arqSoft.baseService.dto.AlquilerRequestDto;
import ar.edu.ucc.arqSoft.baseService.dto.AlquilerResponseDto;
import ar.edu.ucc.arqSoft.baseService.service.AlquilerService;

@Controller
@RequestMapping("/alquiler")
public class AlquilerController {

	@Autowired
	private AlquilerService alquilerService;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public @ResponseBody AlquilerResponseDto registrar(@RequestBody AlquilerRequestDto request) {
		//return alquilerService.registrarAlquiler(request);
		return null;
	}
}
