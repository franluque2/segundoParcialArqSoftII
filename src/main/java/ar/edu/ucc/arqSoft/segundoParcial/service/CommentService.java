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
		
		
		/*
		task.setName(dto.getTaskName());
		task.setBody(dto.getBody());
		task.setUser(userDao.load(dto.getUserId()));
		task.setProject(projectDao.load(dto.getProjectId()));
		task.setState(stateDao.load(dto.getStateId()));
		task.setDateStart(Calendar.getInstance().getTime());
		
		taskDao.insert(task);
		
		TaskResponseDto response=new TaskResponseDto();
		
		response.setName(task.getName());
		response.setUserId(task.getUser().getId());
		response.setProjectId(task.getProject().getId());
		response.setDate(task.getDateStart());
		
		// Mail try catch
		*/
		return response;
		
	}
	
	public CommentResponseDto getCommentById (Long id) throws EntityNotFoundException, BadRequestException {
		
		if (id <= 0) {
			throw new BadRequestException();
		}
		/*
		Task task = taskDao.load(id);
		TaskResponseDto dto=new TaskResponseDto();
		dto.setName(task.getName());
		dto.setBody(task.getBody());
		dto.setUserId(task.getUser().getId());
		dto.setProjectId(task.getProject().getId());
		dto.setState(task.getState());
		dto.setDateStart(task.getDateStart());
		dto.setDateEnd(task.getDateEnd());
		dto.setComments(task.getComments());
		
		*/
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
