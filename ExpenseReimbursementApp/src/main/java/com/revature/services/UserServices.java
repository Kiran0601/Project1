package com.revature.services;

import com.revature.dao.*;
import com.revature.model.*;

public class UserServices {
	
    private UserDao userDao;

    public UserServices() {
        this.userDao = new UserDao();
    }
 
    public User authenticateUser(User u) {
    	User temp = userDao.getUserByUsername(u.getUsername());
		if (temp == null) {
    		return null;
    	}else {
    		if (temp.getPassword().equals(u.getPassword())) {
    			System.out.println(temp.getFname());
    			return temp;
    		}
    	}
		return null;
    }


}