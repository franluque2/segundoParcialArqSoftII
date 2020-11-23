package ar.edu.ucc.arqSoft.segundoParcial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.edu.ucc.arqSoft.common.exception.BadRequestException;
import ar.edu.ucc.arqSoft.common.exception.EntityNotFoundException;
import ar.edu.ucc.arqSoft.segundoParcial.dto.UserAddProjectDto;
import ar.edu.ucc.arqSoft.segundoParcial.dto.UserResponseDto;
import ar.edu.ucc.arqSoft.segundoParcial.service.UserService;

@Controller
@RequestMapping("/userAdd")
public class UserControler_AddProject {
	
	@Autowired
	UserService userService;
	
    @RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody UserResponseDto addProject(@RequestBody UserAddProjectDto dto) throws EntityNotFoundException, BadRequestException
    {
    	return userService.addProject(dto);
    } 
}
