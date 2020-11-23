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
import ar.edu.ucc.arqSoft.segundoParcial.dao.ProjectDao;
import ar.edu.ucc.arqSoft.segundoParcial.dto.ProjectRequestDto;
import ar.edu.ucc.arqSoft.segundoParcial.dto.ProjectResponseDto;
import ar.edu.ucc.arqSoft.segundoParcial.model.Project;
import ar.edu.ucc.arqSoft.segundoParcial.model.Task;

@Service
@Transactional
public class ProjectService {
	
	@Autowired
	private ProjectDao projectDao;
	
	public ProjectResponseDto insertProject(ProjectRequestDto dto) throws EntityNotFoundException, BadRequestException {

		Project project = new Project();
		
		project.setName(dto.getName());
		project.setDescription(dto.getDescription());
		project.setStart(Calendar.getInstance().getTime());
		project.setFinish(dto.getFinish());
		//project.setState(dto.getState());
		//project.setUsers(dto.getUsers());
		//project.setTasks(dto.getTasks());
		
		projectDao.insert(project);
		
		ProjectResponseDto response = new ProjectResponseDto();
		
		response.setName(project.getName());
		response.setDescription(project.getDescription());
		response.setFinish(project.getFinish());
		response.setStart(project.getStart());
		response.setState(project.getState());
		//response.setTasks(project.getTasks());
		//response.setTasks(project.getTasks());
		//response.setUsers(project.getUsers());
		
		return response;
	}
	
	public ProjectResponseDto getProjectById (Long id) throws EntityNotFoundException, BadRequestException {
		
		if (id <= 0) {
			throw new BadRequestException();
		}
		
		Project project = projectDao.load(id);
		ProjectResponseDto dto = new ProjectResponseDto();
		dto.setName(project.getName());
		dto.setDescription(project.getDescription());
		dto.setStart(project.getStart());
		dto.setFinish(project.getFinish());
		dto.setState(project.getState().getId());
		//dto.setUsers(project.getUsers());
		//dto.setTasks(project.getTasks());
		
		return dto;
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
			
			responseProject.setName(project.getName());
			responseProject.setDescription(project.getDescription());
			responseProject.setStart(project.getStart());
			responseProject.setFinish(project.getFinish());
			responseProject.setStateId(project.getState().getId());
			
			response.add(responseProject);
			
		}
		
		/*
		List<Project> projects = projectDao.getAll();
		
		List<ProjectResponseDto> response = new ArrayList<ProjectResponseDto>();
		
		for (Project project : projects) {
			response.add((ProjectResponseDto) new ModelDtoConverter().convertToDto(project, new ProjectResponseDto()));
		}
		*/	
		return response;
	}
	
	public ProjectResponseDto getProjectByName (String name) throws EntityNotFoundException, BadRequestException {
		
		List<Project> projects = projectDao.getAll();
		
		for (Project project : projects) {
			if(project.getName() == name) {
				return getProjectById(project.getId());
			}
		}
		return null;
	}
	
	
}
