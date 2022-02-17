package com.revature.dao;
import com.revature.model.*;

public interface UserDaoInit {
	User getUserById(int id);
    User getUserByEmail(String email);
    User getUserByUsername(String username);
}
