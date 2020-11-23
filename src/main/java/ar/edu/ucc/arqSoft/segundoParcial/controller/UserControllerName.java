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
import ar.edu.ucc.arqSoft.segundoParcial.dto.UserResponseDto;
import ar.edu.ucc.arqSoft.segundoParcial.service.UserService;

@Controller
@RequestMapping("/userName")
public class UserControllerName {
	
	@Autowired
	private UserService userService;
	
    @RequestMapping(value="/{name}", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody UserResponseDto getUserByName(@PathVariable("name") String name) throws EntityNotFoundException, BadRequestException {
    	return userService.getUserByName(name);
    }
}
