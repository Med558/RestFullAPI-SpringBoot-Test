package org.sid.service;

import org.sid.entities.AppRole;
import org.sid.entities.User;

public interface AccountService {

	public User saveUser(String username,String password,String confirmedPassword);
	public AppRole save(AppRole role);
	public User loadUserByUsername(String username);
	public void addRoleToUser(String username,String roleName);
}
