package ar.edu.ucc.arqSoft.segundoParcial.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.ucc.arqSoft.common.dto.ModelDtoConverter;
import ar.edu.ucc.arqSoft.common.exception.BadRequestException;
import ar.edu.ucc.arqSoft.common.exception.EntityNotFoundException;
import ar.edu.ucc.arqSoft.segundoParcial.dao.ProjectDao;
import ar.edu.ucc.arqSoft.segundoParcial.dao.UserDao;
import ar.edu.ucc.arqSoft.segundoParcial.dto.UserAddProjectDto;
import ar.edu.ucc.arqSoft.segundoParcial.dto.UserRequestDto;
import ar.edu.ucc.arqSoft.segundoParcial.dto.UserResponseDto;
import ar.edu.ucc.arqSoft.segundoParcial.model.Project;
import ar.edu.ucc.arqSoft.segundoParcial.model.User;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ProjectDao projectDao;
	
	public UserResponseDto insertUser (UserRequestDto dto) throws EntityNotFoundException, BadRequestException  {
		
		User user = new User();
		
		user.setName(dto.getName());
		user.setLastName(dto.getLastName());
		user.setAdress(dto.getAdress());
		user.setEmail(dto.getEmail());
		user.setPhone(dto.getPhone());
		user.setDNI(dto.getDNI());
		user.setInscription(dto.getInscription());
		user.setBirthday(dto.getBirthday());
		user.setUsername(dto.getUsername());
		user.setPassword(dto.getPassword());
		user.setPermits(dto.getPermits());
		
		userDao.insert(user);
		
		UserResponseDto response = new UserResponseDto();
		
		response.setName(user.getName());
		response.setLastName(user.getLastName());
		response.setUsername(user.getUsername());
		response.setPermits(user.getPermits());
		response.setAdress(user.getAdress());
		response.setEmail(user.getEmail());
		response.setPhone(user.getPhone());
		response.setDNI(user.getDNI());
		response.setInscription(user.getInscription());
		response.setBirthday(user.getBirthday());
		response.setPassword(user.getPassword());
		response.setPermits(user.getPermits());
		
		return response;
	}
	
	public UserResponseDto getUserById (Long id) throws EntityNotFoundException, BadRequestException {
		
		if (id <= 0) {
			throw new BadRequestException();
		}
		
		User user = userDao.load(id);
		UserResponseDto dto = new UserResponseDto();
		
		dto.setName(user.getName());
		dto.setLastName(user.getLastName());
		dto.setAdress(user.getAdress());
		dto.setEmail(user.getEmail());
		dto.setPhone(user.getPhone());
		dto.setDNI(user.getDNI());
		dto.setInscription(user.getInscription());
		dto.setBirthday(user.getBirthday());
		dto.setUsername(user.getUsername());
		dto.setPassword(user.getPassword());
		for(Project projects : user.getProjects()) {
			dto.addProject(projects);
		}
		//dto.setProjects(user.getProjects());
		
		return dto;
	}
	
	public List<UserResponseDto> getAllUsers(){
		
		List<User> users = userDao.getAll();
		
		List<UserResponseDto> response = new ArrayList<UserResponseDto>();
		
		for (User user : users) {
			UserResponseDto dto = new UserResponseDto();
			dto.setAdress(user.getAdress());
			dto.setBirthday(user.getBirthday());
			dto.setDNI(user.getDNI());
			dto.setEmail(user.getEmail());
			dto.setInscription(user.getInscription());
			dto.setLastName(user.getLastName());
			dto.setPassword(user.getPassword());
			dto.setPermits(user.getPermits());
			dto.setPhone(user.getPhone());
			dto.setName(user.getName());
			dto.setUsername(user.getUsername());
		
			for(Project project : user.getProjects()) {
				dto.addProject(project);
			}
			response.add(dto);
		}
		return response;
	}
	
	public UserResponseDto getUserByName (String name)throws EntityNotFoundException, BadRequestException {
		
		List<User> users = userDao.getAll();
		
		for (User user : users) {
			if(user.getName() == name) {
				return getUserById(user.getId());
			}
		}
	return null;
	}
	
	public UserResponseDto addProject (UserAddProjectDto dto) throws EntityNotFoundException, BadRequestException {
		
		User user = userDao.load(dto.getUserId()); //ok
		Project project = projectDao.load(dto.getProjectId()); //ok
		
		user.addProject(project);
		
		userDao.update(user);
		
		UserResponseDto response = new UserResponseDto();
		
		response.setName(user.getName());
		response.setAdress(user.getAdress());
		response.setBirthday(user.getBirthday());
		response.setDNI(user.getDNI());
		response.setEmail(user.getEmail());
		response.setInscription(user.getInscription());
		response.setLastName(user.getLastName());
		response.setPassword(user.getPassword());
		response.setPermits(user.getPermits());
		response.setPhone(user.getPhone());
		for(Project projects : user.getProjects()) {
			response.addProject(projects);
		}
		
		return response;
	}
}