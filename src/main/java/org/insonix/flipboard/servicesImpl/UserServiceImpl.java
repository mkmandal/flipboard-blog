package org.insonix.flipboard.servicesImpl;

import java.util.List;

import org.insonix.flipboard.dto.UserDto;
import org.insonix.flipboard.models.Role;
import org.insonix.flipboard.models.User;
import org.insonix.flipboard.repositories.RoleRepository;
import org.insonix.flipboard.repositories.UserRepository;
import org.insonix.flipboard.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public UserDto saveUser(UserDto userDto) {
		User user = getUserObj(userDto);
		if (null != user) {
			user = userRepository.save(user);
			userDto = getUserDtoObj(user);
		}
		return userDto;
	}

	@Override
	public UserDto loginUser(UserDto userDto) {
		User user = userRepository.findByUsernameAndPassword(userDto.getUsername(), userDto.getPassword());
		if (null != user) {
			return getUserDtoObj(user);
		}
		return null;
	}

	@Override
	public List<User> listUser() {
		List<User> userList = userRepository.findAll();
		return userList;
	}

	private User getUserObj(UserDto userDto) {
		User user = null;
		if (null != userDto) {
			user = new User();
			if (null != userDto.getId())
				user.setId(userDto.getId());
			user.setFirstName(userDto.getFirstName());
			user.setLastName(userDto.getLastName());
			user.setUsername(userDto.getUsername());
			user.setPassword(userDto.getPassword());
			Role role = roleRepository.findByRoleId(userDto.getRoleId());
			user.setRole(role);
		}
		return user;
	}

	private UserDto getUserDtoObj(User user) {
		UserDto userDto = null;
		if (null != user) {
			userDto = new UserDto();
			userDto.setId(user.getId());
			userDto.setFirstName(user.getFirstName());
			userDto.setLastName(user.getLastName());
			userDto.setUsername(user.getUsername());
			userDto.setPassword(user.getPassword());
		}
		return userDto;
	}

	@Override
	public void deleteUserById(Long userId) {
		userRepository.delete(userId);
	}

}
