package org.insonix.flipboard.repositories;

import org.insonix.flipboard.models.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {

	public User findByUsername(String username);
	
	public User findByUsernameAndPassword(String username, String password);
	
}
