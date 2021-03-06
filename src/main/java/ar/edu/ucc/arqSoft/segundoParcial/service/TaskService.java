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
import ar.edu.ucc.arqSoft.segundoParcial.dto.TaskChangeRequestDto;
import ar.edu.ucc.arqSoft.segundoParcial.dto.TaskChangeStateRequestDto;
import ar.edu.ucc.arqSoft.segundoParcial.dto.TaskRequestDto;
import ar.edu.ucc.arqSoft.segundoParcial.dto.TaskResponseDto;
import ar.edu.ucc.arqSoft.segundoParcial.exception.TaskClosedException;
import ar.edu.ucc.arqSoft.segundoParcial.model.Comment;
import ar.edu.ucc.arqSoft.segundoParcial.model.Task;

@Service
@Transactional
public class TaskService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private TaskDao taskDao;
	
	@Autowired
	private ProjectDao projectDao;
	
	@Autowired
	private StateDao stateDao;
	
	@Autowired
	private CommentDao commentDao;
	
	public TaskResponseDto insertTask (TaskRequestDto dto) throws EntityNotFoundException, BadRequestException {
		
		Task task = new Task();
		
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
		response.setDateStart(task.getDateStart());
		
		// Mail try catch
		
		return response;
		
	}
	
	public TaskResponseDto getTaskById (Long id) throws EntityNotFoundException, BadRequestException {
		
		if (id <= 0) {
			throw new BadRequestException();
		}
		
		Task task = taskDao.load(id);
		TaskResponseDto dto=new TaskResponseDto();
		dto.setName(task.getName());
		dto.setBody(task.getBody());
		dto.setUserId(task.getUser().getId());
		dto.setProjectId(task.getProject().getId());
		dto.setState(task.getState().getId());
		dto.setDateStart(task.getDateStart());
		dto.setDateEnd(task.getDateEnd());
		for(Comment comment : task.getComments())
		{
			dto.addComments(comment);
		}
		return dto;
		
	}
	
	public List<TaskResponseDto> getAllTasksByName(String name) {
		List<Task> tasks = taskDao.getAll();
		
		List<TaskResponseDto> response = new ArrayList<TaskResponseDto>();
		 
		for (Task task : tasks) {
			if(task.getName().equalsIgnoreCase(name))
			response.add((TaskResponseDto) new ModelDtoConverter().convertToDto(task, new TaskResponseDto()));
		}
		
		return response;
	}
	
	
	public List<TaskResponseDto> getAllTasks() {
		List<Task> tasks = taskDao.getAll();
		
		List<TaskResponseDto> response = new ArrayList<TaskResponseDto>();
		 
		for (Task task : tasks) {
			TaskResponseDto responseTask= new TaskResponseDto();
			responseTask.setBody(task.getBody());
			
			if(!task.getComments().isEmpty()) {
				for(Comment comment : task.getComments())
				{
					responseTask.addComments(comment);;
				}
			}
			responseTask.setDateStart(task.getDateStart());
			responseTask.setDateEnd(task.getDateEnd());
			responseTask.setName(task.getName());
			responseTask.setProjectId(task.getProject().getId());
			responseTask.setState(task.getState().getId());
			responseTask.setUserId(task.getUser().getId());
			
			response.add(responseTask);
		}
		
		return response;
	}
	
	public TaskResponseDto changeUser (TaskChangeRequestDto dto) throws EntityNotFoundException,TaskClosedException {
		{
			Task task=taskDao.load(dto.getTaskId());
			
			if(taskDao.load(dto.getTaskId()).getState().getName().equalsIgnoreCase("Closed"))
			{
				throw new TaskClosedException();
			}
			
			Comment comment=new Comment();
			comment.setDate(Calendar.getInstance().getTime());
			comment.setBody("Se cambio el usuario de "+task.getUser().getUsername()+" a "+userDao.load(dto.getUserId()).getUsername()+".");
			comment.setTask(task);
			comment.setName("Cambio de Usuario");
			task.setUser(userDao.load(dto.getUserId()));
			task.addComment(comment);
			taskDao.update(task);
			TaskResponseDto response=new TaskResponseDto();
			
			response.setName(task.getName());
			response.setUserId(task.getUser().getId());
			response.setProjectId(task.getProject().getId());
			response.setDateStart(task.getDateStart());
			
			
			return response;
		}
	}
	
	public TaskResponseDto changeState (TaskChangeStateRequestDto dto) throws EntityNotFoundException,TaskClosedException {
		{
			Task task=taskDao.load(dto.getTaskId());
			
			if(task.getState().getName().equalsIgnoreCase("Closed"))
			{
				if(stateDao.load(dto.getStateId()).getName().equalsIgnoreCase("Open"))
				{
					task.setDateEnd(null);
				}
				else
				{
					throw new TaskClosedException();
				}
			}
			
			Comment comment=new Comment();
			comment.setDate(Calendar.getInstance().getTime());
			comment.setBody("Se cambio el estado de "+task.getState().getName()+" a "+stateDao.load(dto.getStateId()).getName()+".");
			comment.setTask(task);
			comment.setName("Cambio de Estado");
			task.setState(stateDao.load(dto.getStateId()));
			task.addComment(comment);
			if(task.getState().getName().equalsIgnoreCase("Closed"))
			{
				task.setDateEnd(Calendar.getInstance().getTime());
			}
			taskDao.update(task);
			TaskResponseDto response=new TaskResponseDto();
			
			response.setName(task.getName());
			response.setUserId(task.getUser().getId());
			response.setProjectId(task.getProject().getId());
			response.setDateStart(task.getDateStart());
			response.setState(task.getState().getId());
		
			return response;
		}
	} 
	
}
