package ar.edu.ucc.arqSoft.segundoParcial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.edu.ucc.arqSoft.common.exception.BadRequestException;
import ar.edu.ucc.arqSoft.segundoParcial.dto.TaskChangeRequestDto;
import ar.edu.ucc.arqSoft.segundoParcial.dto.TaskResponseDto;
import ar.edu.ucc.arqSoft.segundoParcial.exception.EntityNotFoundException;
import ar.edu.ucc.arqSoft.segundoParcial.exception.TaskClosedException;
import ar.edu.ucc.arqSoft.segundoParcial.service.TaskService;

@Controller
@RequestMapping("/taskChangeUser")
public class TaskControllerChangeUser {
	
	@Autowired
	private TaskService taskService;
	
    @RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody TaskResponseDto changeTaskUser(@RequestBody TaskChangeRequestDto request) throws EntityNotFoundException, BadRequestException, TaskClosedException, ar.edu.ucc.arqSoft.common.exception.EntityNotFoundException
    {
        return taskService.changeUser(request);
    }
    
}
