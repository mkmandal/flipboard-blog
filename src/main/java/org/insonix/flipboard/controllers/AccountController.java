package org.insonix.flipboard.controllers;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.insonix.flipboard.dto.UserDto;
import org.insonix.flipboard.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public UserDto loginUser(@RequestBody UserDto userDto) {
		return userService.loginUser(userDto);
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public UserDto saveUser(@RequestBody UserDto userDto) {
		return userService.saveUser(userDto);

	}

}
