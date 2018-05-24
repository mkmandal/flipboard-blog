package org.insonix.flipboard.repositories;

import org.insonix.flipboard.models.Role;

public interface RoleRepository extends BaseRepository<Role, Long> {

	public Role findByRoleId(Long roleId);

}
