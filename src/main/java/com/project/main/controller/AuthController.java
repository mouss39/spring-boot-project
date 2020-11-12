package com.project.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.main.model.AuthUser;
import com.project.main.model.User;
import com.project.main.services.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	UserService userService;

	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> Login(@RequestBody AuthUser authUser) {

		User user = userService.checkUser(authUser);

		if (user != null)
			return new ResponseEntity<>(user, HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

	}

}
