package org.insonix.flipboard.controllers;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.insonix.flipboard.dto.UserDto;
import org.insonix.flipboard.models.User;
import org.insonix.flipboard.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/listUser", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	public List<User> retrieveUser() {
		return userService.listUser();
	}

	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	public void deleteUser(@PathVariable("id") Long userId) {
		userService.deleteUserById(userId);
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public UserDto saveUser(@RequestBody UserDto userDto) {
		return userService.saveUser(userDto);

	}
	
	
	
	

}