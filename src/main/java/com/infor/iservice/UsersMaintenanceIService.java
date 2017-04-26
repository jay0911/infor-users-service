package com.infor.iservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infor.dao.UsersMaintananceDao;
import com.infor.dto.UserMaintenanceDTO;
import com.infor.models.InforUser;
import com.infor.service.UsersMaintenanceService;
/**
 * 
 * @author joliveros
 * @see InforUser
 * @since 1.0
 */
@Service
public class UsersMaintenanceIService implements UsersMaintenanceService{
	
	@Autowired
	private UsersMaintananceDao md;

	@Override
	public UserMaintenanceDTO getUser(InforUser user) {
		// TODO Auto-generated method stub
		List<InforUser> users = md.getUser(user);
		UserMaintenanceDTO dto = new UserMaintenanceDTO();
		dto.setInforUser(users.get(0));
		return dto; 
	}

	@Override
	public void saveUser(InforUser user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(InforUser user) {
		// TODO Auto-generated method stub
		md.updateUser(user);
	}

	@Override
	public void removeUser(InforUser user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveRegistration(UserMaintenanceDTO dto) {
		// TODO Auto-generated method stub
		InforUser user = new InforUser();
		setUserFromDTO(dto,user);
		md.saveRegistration(user);
	}
	
	private void setUserFromDTO (UserMaintenanceDTO dto,InforUser user){
		user.setFirstname(dto.getFirstname());
		user.setLastname(dto.getLastname());
		user.setEmailaddress(dto.getEmailaddress());
		user.setInforaddress(dto.getAddress());
		user.setContactnumber(dto.getContactnumber());
		user.setPosition(dto.getPosition());
		user.setGender(dto.getGender());
		user.setUsername(dto.getUsername());
		user.setPassword(dto.getPassword());
	}

	@Override
	public boolean isUsernameExisting(UserMaintenanceDTO dto) {
		InforUser u = new InforUser();
		this.setUserFromDTO(dto,u);
		return md.isUsernameExisting(u);
	}

	@Override
	public UserMaintenanceDTO getuserloggedinInfo(UserMaintenanceDTO dto) {
		// TODO Auto-generated method stub
		InforUser user = new InforUser();
		user.setUsername(dto.getUsername());
		return this.getUser(user);
	}

	@Override
	public void modifyuser(UserMaintenanceDTO dto) {
		// TODO Auto-generated method stub
		InforUser u = new InforUser();
		this.setUserFromDTO(dto,u);
		this.updateUser(u);
	}

}
