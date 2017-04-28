package com.infor.service;
import com.infor.dto.MaintenanceDTO;
import com.infor.models.InforUser;

public interface UsersMaintenanceService {
	public MaintenanceDTO getUser(InforUser user);
	public MaintenanceDTO getUsers();
	public void saveUser(InforUser user);
	public void updateUser(InforUser user);
	public void removeUser(InforUser user);
	public void modifyuser(MaintenanceDTO dto);
	
	public void saveRegistration(MaintenanceDTO dto);
	public boolean isUsernameExisting(MaintenanceDTO dto);
	
	public MaintenanceDTO getuserloggedinInfo(MaintenanceDTO dto);
	
}	
