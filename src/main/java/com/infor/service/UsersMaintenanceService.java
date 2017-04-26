package com.infor.service;
import com.infor.dto.UserMaintenanceDTO;
import com.infor.models.InforUser;

public interface UsersMaintenanceService {
	public UserMaintenanceDTO getUser(InforUser user);
	public void saveUser(InforUser user);
	public void updateUser(InforUser user);
	public void removeUser(InforUser user);
	public void modifyuser(UserMaintenanceDTO dto);
	
	public void saveRegistration(UserMaintenanceDTO dto);
	public boolean isUsernameExisting(UserMaintenanceDTO dto);
	
	public UserMaintenanceDTO getuserloggedinInfo(UserMaintenanceDTO dto);
	
}	
