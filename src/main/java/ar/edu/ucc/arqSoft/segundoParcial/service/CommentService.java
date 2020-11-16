package ar.edu.ucc.arqSoft.segundoParcial.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.ucc.arqSoft.common.dto.ModelDtoConverter;
import ar.edu.ucc.arqSoft.common.exception.BadRequestException;
import ar.edu.ucc.arqSoft.common.exception.EntityNotFoundException;
import ar.edu.ucc.arqSoft.segundoParcial.dao.CommentDao;
import ar.edu.ucc.arqSoft.segundoParcial.dao.ProjectDao;
import ar.edu.ucc.arqSoft.segundoParcial.dao.StateDao;
import ar.edu.ucc.arqSoft.segundoParcial.dao.TaskDao;
import ar.edu.ucc.arqSoft.segundoParcial.dao.UserDao;
import ar.edu.ucc.arqSoft.segundoParcial.dto.CommentRequestDto;
import ar.edu.ucc.arqSoft.segundoParcial.dto.CommentResponseDto;
import ar.edu.ucc.arqSoft.segundoParcial.dto.TaskChangeRequestDto;
import ar.edu.ucc.arqSoft.segundoParcial.dto.TaskRequestDto;
import ar.edu.ucc.arqSoft.segundoParcial.dto.TaskResponseDto;
import ar.edu.ucc.arqSoft.segundoParcial.model.Comment;
import ar.edu.ucc.arqSoft.segundoParcial.model.Task;

@Service
@Transactional
public class CommentService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private TaskDao taskDao;
		
	@Autowired
	private CommentDao commentDao;
	
	public CommentResponseDto insertComment (CommentRequestDto dto) throws EntityNotFoundException, BadRequestException {
		
		Comment comment = new Comment();
		comment.setName(dto.getName());
		comment.setBody(dto.getBody());
		comment.setUser(userDao.load(dto.getUserId()));
		comment.setTask(taskDao.load(dto.getTaskId()));
		comment.setDate(Calendar.getInstance().getTime());
		
		commentDao.insert(comment);
		
		CommentResponseDto response=new CommentResponseDto();
		
		response.setName(comment.getName());
		response.setUserId(comment.getUser().getId());
		response.setBody(comment.getBody());
		response.setDate(comment.getDate());
		
		return response;
		
	}
	
	public CommentResponseDto getCommentById (Long id) throws EntityNotFoundException, BadRequestException {
		
		if (id <= 0) {
			throw new BadRequestException();
		}
		Comment comment=commentDao.load(id);
	
		CommentResponseDto dto=new CommentResponseDto();
		dto.setBody(comment.getBody());
		dto.setDate(comment.getDate());
		dto.setName(comment.getName());
		dto.setTaskId(comment.getTask().getId());
		dto.setUserId(comment.getUser().getId());
		
	
		return dto;
		
	}
	public List<CommentResponseDto> getAllCommentsFromTask(Long taskId) {
		List<Comment> comments = commentDao.getAll();
		
		List<CommentResponseDto> response = new ArrayList<CommentResponseDto>();
		 
		for (Comment comment : comments) {
			if(comment.getTask().getId()==taskId)
			{
				response.add((CommentResponseDto) new ModelDtoConverter().convertToDto(comment, new CommentResponseDto()));
	
			}
			
		}
		
		return response;
	}
	
	public List<CommentResponseDto> getAllComments() {
		List<Comment> comments = commentDao.getAll();
		
		List<CommentResponseDto> response = new ArrayList<CommentResponseDto>();
		 
		for (Comment comment : comments) {
			
			
				response.add((CommentResponseDto) new ModelDtoConverter().convertToDto(comment, new CommentResponseDto()));
	
			
			
		}
		
		return response;
	}
	
	
	
}
