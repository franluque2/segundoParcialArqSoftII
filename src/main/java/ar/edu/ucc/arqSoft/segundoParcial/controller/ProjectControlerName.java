package ar.edu.ucc.arqSoft.segundoParcial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.edu.ucc.arqSoft.common.exception.BadRequestException;
import ar.edu.ucc.arqSoft.common.exception.EntityNotFoundException;
import ar.edu.ucc.arqSoft.segundoParcial.dto.ProjectResponseDto;
import ar.edu.ucc.arqSoft.segundoParcial.service.ProjectService;

@Controller
@RequestMapping("/projectName")
public class ProjectControlerName {
	
	@Autowired
	private ProjectService projectService;
	
    @RequestMapping(value="/{name}", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ProjectResponseDto getUserById(@PathVariable("name") String name) throws EntityNotFoundException, BadRequestException {
    	return projectService.getProjectByName(name);
    }
}
