package ar.edu.ucc.arqSoft.baseService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.edu.ucc.arqSoft.baseService.dto.StateRequestDto;
import ar.edu.ucc.arqSoft.baseService.dto.StateResponseDto;
import ar.edu.ucc.arqSoft.baseService.service.StateService;

@Controller
@RequestMapping("/state")
public class StateController {
	
	@Autowired
    private StateService stateService;

    @RequestMapping(method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<StateResponseDto> getAllStates()
    {
        return stateService.getAllStates();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody StateResponseDto lookupStateById(@PathVariable("id") Long id)
    {
        return stateService.getStateById(id);
    }
    
    @RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody StateResponseDto saveSatate(@RequestBody StateRequestDto request)
    {
        return stateService.insertState(request);
    }
}
