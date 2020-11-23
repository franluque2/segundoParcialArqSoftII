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
import ar.edu.ucc.arqSoft.segundoParcial.dto.CommentRequestDto;
import ar.edu.ucc.arqSoft.segundoParcial.dto.CommentResponseDto;
import ar.edu.ucc.arqSoft.segundoParcial.dto.TaskChangeRequestDto;
import ar.edu.ucc.arqSoft.segundoParcial.dto.TaskChangeStateRequestDto;
import ar.edu.ucc.arqSoft.segundoParcial.dto.TaskRequestDto;
import ar.edu.ucc.arqSoft.segundoParcial.dto.TaskResponseDto;
import ar.edu.ucc.arqSoft.segundoParcial.exception.TaskClosedException;
import ar.edu.ucc.arqSoft.segundoParcial.service.CommentService;
import ar.edu.ucc.arqSoft.segundoParcial.service.TaskService;

@Controller
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
    @RequestMapping(method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<TaskResponseDto> getAllTasks()
    {
        return taskService.getAllTasks();
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody TaskResponseDto getTaskById(@PathVariable("id") Long id) throws EntityNotFoundException, BadRequestException {
    	return taskService.getTaskById(id);
		//return null;
    }
    
    @RequestMapping(value="/taskName/{name}", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<TaskResponseDto> getTasksByName(@PathVariable("name") String name) throws EntityNotFoundException, BadRequestException {
    	return taskService.getAllTasksByName(name);
		//return null;
    }
    
    
    @RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody TaskResponseDto saveTask(@RequestBody TaskRequestDto request) throws EntityNotFoundException, BadRequestException, TaskClosedException
    {
        return taskService.insertTask(request);
    }
    
    @RequestMapping(value="/taskName/changeUser",method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody TaskResponseDto changeTaskUser(@RequestBody TaskChangeRequestDto request) throws EntityNotFoundException, BadRequestException, TaskClosedException
    {
        return taskService.changeUser(request);
    }
    
    @RequestMapping(value="/taskName/changeState",method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody TaskResponseDto changeTaskState(@RequestBody TaskChangeStateRequestDto request) throws EntityNotFoundException, BadRequestException, TaskClosedException
    {
        return taskService.changeState(request);
    }
    

}
