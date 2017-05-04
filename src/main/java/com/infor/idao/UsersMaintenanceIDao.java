package com.infor.idao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import com.infor.dao.UsersMaintananceDao;
import com.infor.models.InforUser;

@Repository
@Transactional
public class UsersMaintenanceIDao extends HibernateDaoSupport implements UsersMaintananceDao{

	private static final String USER_FETCH_HQL = "from InforUser where username=:username";
	private static final String USERS_FETCH_HQL = "from InforUser";
	private static final String USER_MODIFY_HQL = "update InforUser set firstname=:firstname, lastname=:lastname,contactnumber=:contactnumber, emailaddress=:emailaddress, inforaddress=:inforaddress,position=:position,gender=:gender,username=:username,password=:password where username=:username";
	private static final String USER_PARKING_FETCH_HQL = "from InforUser as user where user.userid not in (select inforparking.userid from InforParking as inforparking)";
	
	@SuppressWarnings("unchecked")
	@Override
	public List<InforUser> getUser(InforUser user) {
		// TODO Auto-generated method stub
		return customSelectQuery(USER_FETCH_HQL)
				.setParameter("username", user.getUsername())
				.list();
	}

	@Override
	public void saveUser(InforUser user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(InforUser user) {
		// TODO Auto-generated method stub
		Query q= getSessionFactory().createQuery(USER_MODIFY_HQL);
		q.setParameter("firstname", user.getFirstname());
		q.setParameter("lastname", user.getLastname());
		q.setParameter("contactnumber", user.getContactnumber());
		q.setParameter("emailaddress", user.getEmailaddress());
		q.setParameter("inforaddress", user.getInforaddress());
		q.setParameter("position", user.getPosition());
		q.setParameter("gender", user.getGender());
		q.setParameter("username", user.getUsername());
		q.setParameter("password", user.getPassword());
		q.executeUpdate();
	}

	@Override
	public void removeUser(InforUser user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveRegistration(InforUser user) {
		// TODO Auto-generated method stub
		getSessionFactory().save(user);
	}

	@Override
	public void modifyUser(InforUser user) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isUsernameExisting(InforUser user) {
		List<InforUser> userlist = customSelectQuery(USER_FETCH_HQL)
				.setParameter("username", user.getUsername())
				.list();
		if(userlist.size() > 0){
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InforUser> getUsers() {
		// TODO Auto-generated method stub
		return customSelectQuery(USERS_FETCH_HQL)
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InforUser> getallavailuerforparking() {
		// TODO Auto-generated method stub
		return customSelectQuery(USER_PARKING_FETCH_HQL)
				.list();
	}

}
