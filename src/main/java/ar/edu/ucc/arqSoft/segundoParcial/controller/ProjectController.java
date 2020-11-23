package ar.edu.ucc.arqSoft.segundoParcial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.edu.ucc.arqSoft.common.exception.BadRequestException;
import ar.edu.ucc.arqSoft.common.exception.EntityNotFoundException;
import ar.edu.ucc.arqSoft.segundoParcial.dto.ProjectRequestDto;
import ar.edu.ucc.arqSoft.segundoParcial.dto.ProjectResponseDto;
import ar.edu.ucc.arqSoft.segundoParcial.service.ProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
    @RequestMapping(method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<ProjectResponseDto> getAllUsers() throws EntityNotFoundException, BadRequestException
    {
        return projectService.getAllProjects();
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ProjectResponseDto getUserById(@PathVariable("id") Long id) throws EntityNotFoundException, BadRequestException {
    	return projectService.getProjectById(id);
    }
    
    @RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ProjectResponseDto insertTask(@RequestBody ProjectRequestDto request) throws EntityNotFoundException, BadRequestException
    {
    	return projectService.insertProject(request);
    } 

}
