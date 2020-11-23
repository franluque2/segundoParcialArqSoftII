package ar.edu.ucc.arqSoft.segundoParcial.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.ucc.arqSoft.common.exception.BadRequestException;
import ar.edu.ucc.arqSoft.common.exception.EntityNotFoundException;
import ar.edu.ucc.arqSoft.segundoParcial.dao.ProjectDao;
import ar.edu.ucc.arqSoft.segundoParcial.dao.StateDao;
import ar.edu.ucc.arqSoft.segundoParcial.dto.ProjectRequestDto;
import ar.edu.ucc.arqSoft.segundoParcial.dto.ProjectResponseDto;
import ar.edu.ucc.arqSoft.segundoParcial.model.Project;
import ar.edu.ucc.arqSoft.segundoParcial.model.Task;
import ar.edu.ucc.arqSoft.segundoParcial.model.User;

@Service
@Transactional
public class ProjectService {
	
	@Autowired
	private ProjectDao projectDao;
	
	@Autowired
	private StateDao stateDao;
	
	public ProjectResponseDto insertProject(ProjectRequestDto dto) throws EntityNotFoundException, BadRequestException {

		Project project = new Project();
		
		project.setName(dto.getName());
		project.setDescription(dto.getDescription());
		project.setStart(Calendar.getInstance().getTime());
		project.setFinish(dto.getFinish());
		project.setState(stateDao.load(dto.getState()));
		
		projectDao.insert(project);
		
		ProjectResponseDto response = new ProjectResponseDto();
		
		response.setName(project.getName());
		response.setDescription(project.getDescription());
		response.setFinish(project.getFinish());
		response.setStart(project.getStart());
		response.setStateId(project.getState().getId());

		return response;
	}
	
	public ProjectResponseDto getProjectById (Long id) throws EntityNotFoundException, BadRequestException {
		
		if (id <= 0) {
			throw new BadRequestException();
		}
		
		Project project = projectDao.load(id);
		ProjectResponseDto response = new ProjectResponseDto();
		response.setName(project.getName());
		response.setDescription(project.getDescription());
		response.setStart(project.getStart());
		response.setFinish(project.getFinish());
		response.setStateId(project.getState().getId());
		
		//get all tasks
		if(!project.getTasks().isEmpty()) {
			for(Task task : project.getTasks()) {
				response.addTask(task);
			}
		}
		//users
		if(!project.getUsers().isEmpty()) {
			for(User user : project.getUsers()) {
				response.addUser(user);
			}
		}
		
		return response;
	}
	
	public List<ProjectResponseDto> getAllProjects () throws EntityNotFoundException, BadRequestException{
		
		List<Project> projects = projectDao.getAll();
		
		List<ProjectResponseDto> response = new ArrayList<ProjectResponseDto>();
		
		for(Project project : projects) {
			ProjectResponseDto responseProject = new ProjectResponseDto();
			
			//get all tasks
			if(!project.getTasks().isEmpty()) {
				for(Task task : project.getTasks()) {
					responseProject.addTask(task);
				}
			}
			//users
			if(!project.getUsers().isEmpty()) {
				for(User user : project.getUsers()) {
					responseProject.addUser(user);
				}
			}
			
			responseProject.setName(project.getName());
			responseProject.setDescription(project.getDescription());
			responseProject.setStart(project.getStart());
			responseProject.setFinish(project.getFinish());
			responseProject.setStateId(project.getState().getId());
			
			response.add(responseProject);
			
		}
		return response;
	}
	
	public ProjectResponseDto getProjectByName (String name) throws EntityNotFoundException, BadRequestException {
		
		if (name.isEmpty()) {
			throw new BadRequestException();
		}
		
		List<Project> projects = projectDao.getAll();
		
		ProjectResponseDto response = new ProjectResponseDto();
		
		for(Project project : projects) {
			
			if(project.getName().equalsIgnoreCase(name)) {
		
					response.setName(project.getName());
					response.setDescription(project.getDescription());
					response.setStart(project.getStart());
					response.setFinish(project.getFinish());
					response.setStateId(project.getState().getId());
		
					//get all tasks
					if(!project.getTasks().isEmpty()) {
						for(Task task : project.getTasks()) {
							response.addTask(task);
						}
					}
					//users
					if(!project.getUsers().isEmpty()) {
						for(User user : project.getUsers()) {
							response.addUser(user);
						}
					}
			}
				}

		
		return response;
		
		/*
		List<Project> projects = projectDao.getAll();
		
		for (Project project : projects) {
			if(project.getName().equalsIgnoreCase(name)) {
				return getProjectById(project.getId());
			}
		}
		return null;
		*/
	}
	
	
}
