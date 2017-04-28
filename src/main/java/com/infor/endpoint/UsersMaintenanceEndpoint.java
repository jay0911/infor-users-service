package com.infor.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infor.dto.MaintenanceDTO;
import com.infor.models.AjaxResponseBody;
import com.infor.service.UsersMaintenanceService;

@RestController
public class UsersMaintenanceEndpoint {

	@Autowired
	private UsersMaintenanceService s;
	
	@PostMapping("/registeruserservice")
	public AjaxResponseBody saveRegistration(@RequestBody MaintenanceDTO dto){
		AjaxResponseBody response = new AjaxResponseBody();
		if(s.isUsernameExisting(dto)){
			response.setMsg("user exist");
			response.setCode("400");
			return response;
		}
		
		s.saveRegistration(dto);	
		response.setMsg("success");
		response.setCode("200");
		return response;
	}
	
	@PostMapping("/checkcredentials")
	public MaintenanceDTO checkCredentials(@RequestBody MaintenanceDTO dto){
		return s.getUser(dto.getInforUser());
	}
	
	@PostMapping("/getuserinfo")
	public MaintenanceDTO currentuserinfo(@RequestBody MaintenanceDTO dto){
		return s.getuserloggedinInfo(dto);
	}
	
	@PostMapping("/modifyuser")
	public AjaxResponseBody modifyAccount(@RequestBody MaintenanceDTO dto){
		AjaxResponseBody response = new AjaxResponseBody();
		

		try{
			s.modifyuser(dto);	
			response.setMsg("success");
			response.setCode("200");
		}catch(Exception e){
			response.setMsg("failed");
			response.setCode("400");
		}
		return response;
	}
	
	@PostMapping("/getllusers")
	public MaintenanceDTO getllusers(@RequestBody MaintenanceDTO dto){
		return s.getUsers();
	}
	
}
