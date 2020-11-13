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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	@ApiOperation(value = "add user", response = Integer.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully updated user") })
	@PostMapping(value = "/addUser", consumes = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> addUser(@RequestBody User user) {
		System.out.println("here I am");
		User userTemp = userService.checkUser(user.getEmail());
		// to make sure the same user does not exist
		if (userTemp.getEmail() != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		userService.addUser(user);

		return new ResponseEntity<>(HttpStatus.OK);
	}
//
//	@GetMapping(value = "/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
//	@ApiOperation(value = "Fetch a single user by email", response = User.class)
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved user", response = User.class),
//			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
//			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
//			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
//			@ApiResponse(code = 500, message = "Something went wrong") })
//	ResponseEntity<?> getUser(@PathVariable("email") String username) {
//
//		return new ResponseEntity<>(HttpStatus.OK);
//
//	}

}
