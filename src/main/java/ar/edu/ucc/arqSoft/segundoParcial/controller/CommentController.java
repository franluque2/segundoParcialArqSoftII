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
import ar.edu.ucc.arqSoft.segundoParcial.exception.TaskClosedException;
import ar.edu.ucc.arqSoft.segundoParcial.service.CommentService;

@Controller
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
    @RequestMapping(method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<CommentResponseDto> getAllComments()
    {
        return commentService.getAllComments();
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody CommentResponseDto getCommentById(@PathVariable("id") Long id) throws EntityNotFoundException, BadRequestException {
    	return commentService.getCommentById(id);
    }
    @RequestMapping(value="/task/{id}", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<CommentResponseDto> getAllCommentsByTaskId(@PathVariable("id") Long id) throws EntityNotFoundException, BadRequestException {
    	return commentService.getAllCommentsFromTask(id);
    }
    
    @RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody CommentResponseDto saveComment(@RequestBody CommentRequestDto request) throws EntityNotFoundException, BadRequestException, TaskClosedException
    {
        return commentService.insertComment(request);
    }
    

}
