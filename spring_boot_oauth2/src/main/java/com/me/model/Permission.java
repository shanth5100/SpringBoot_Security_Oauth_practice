package com.me.model;

import javax.persistence.Entity;

import com.me.model.supr.IDGenarator;

@Entity
public class Permission extends IDGenarator{

	private String permissions;

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}
	
}
