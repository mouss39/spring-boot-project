package com.project.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.main.model.User;
import com.project.main.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping(value = "/addUser", consumes = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> addUser(@RequestBody User user) {

//		User userTemp = userService.checkUser(user.getEmail());
//		// to make sure the same user does not exist
//		if (userTemp.getEmail() != null) {
//			return new ResponseEntity<>(HttpStatus.CONFLICT);
//		}
//		userService.addUser(user);

		return new ResponseEntity<>(HttpStatus.OK);
	}

}
