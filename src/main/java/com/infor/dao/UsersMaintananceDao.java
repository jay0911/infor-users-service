package com.infor.dao;

import java.util.List;
import com.infor.models.InforUser;

public interface UsersMaintananceDao {
	public List<InforUser> getUser(InforUser user);
	public List<InforUser> getUsers();
	public void saveUser(InforUser user);
	public void updateUser(InforUser user);
	public void removeUser(InforUser user);

	public void saveRegistration(InforUser user);
	public void modifyUser(InforUser user);
	public boolean isUsernameExisting(InforUser user);
	
}
