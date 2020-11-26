package com.me.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.me.model.supr.IDGenarator;

@Entity
public class Role extends IDGenarator{

	private String role;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "permission_role", joinColumns = {
			@JoinColumn(name = "role_id", referencedColumnName = "id")
	}, inverseJoinColumns = {
			@JoinColumn(name = "permission_id", referencedColumnName = "id")
	})
	private java.util.List<Permission> permissions;

	public java.util.List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(java.util.List<Permission> permissions) {
		this.permissions = permissions;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
