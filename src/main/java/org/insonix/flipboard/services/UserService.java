package org.insonix.flipboard.services;

import java.util.List;

import org.insonix.flipboard.dto.UserDto;
import org.insonix.flipboard.models.User;

public interface UserService extends BaseService<User, Long> {

	public UserDto saveUser(UserDto userDto);
	
	public UserDto loginUser(UserDto userDto);
	
	public List<User> listUser();
	
	public void deleteUserById(Long id);
	
    
	
	

	
	
	

}
