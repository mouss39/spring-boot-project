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

	public User checkUser(AuthUser user) {
		User res = userQuery.checkUser(user);
		return res;
	}

}
