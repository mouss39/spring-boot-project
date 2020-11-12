package com.project.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.main.mapper.UserQuery;
import com.project.main.model.AuthUser;
import com.project.main.model.User;

@Service
public class UserService {

	@Autowired
	UserQuery userQuery;

	public User authUser(AuthUser user) {
		User res = userQuery.authUser(user);
		return res;
	}

	public User checkUser(String email) {
		User res = userQuery.checkUser(email);
		return res;
	}

	public void addUser(User user) {
		userQuery.addUser(user);

	}

}
