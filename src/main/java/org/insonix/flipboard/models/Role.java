package org.insonix.flipboard.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROLE")
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9103612995425439877L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long roleId;

	@Column(name = "ROLE_NAME", nullable = false)
	private String roleName;
	
	

	public Role() {
	}

	public Role(Long roleId) {
		this.roleId = roleId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
