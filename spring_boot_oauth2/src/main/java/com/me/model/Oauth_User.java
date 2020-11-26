package com.me.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.me.model.supr.IDGenarator;

@Entity
public class Oauth_User extends IDGenarator implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;
	private String username;
	private String password;
	
	private boolean enabled;
	
	@Column(name = "account_locked")
	private boolean accNonLocked;
	@Column(name = "account_expired")
	private boolean accNonExpired;
	@Column(name = "credentials_expired")
	private boolean credentialsNonExpired;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "role_user", joinColumns = {
			@JoinColumn(name = "user_id", referencedColumnName = "id")
	}, inverseJoinColumns = {
			@JoinColumn(name = "role_id", referencedColumnName = "id")
	})
	private java.util.List<Role> roles;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public boolean isAccNonLocked() {
		return accNonLocked;
	}
	public void setAccNonLocked(boolean accNonLocked) {
		this.accNonLocked = accNonLocked;
	}
	public boolean isAccNonExpired() {
		return accNonExpired;
	}
	public void setAccNonExpired(boolean accNonExpired) {
		this.accNonExpired = accNonExpired;
	}
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	public java.util.List<Role> getRoles() {
		return roles;
	}
	public void setRoles(java.util.List<Role> roles) {
		this.roles = roles;
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
