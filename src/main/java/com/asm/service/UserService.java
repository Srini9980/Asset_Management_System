package com.asm.service;

import java.util.List;

import com.asm.entity.User;

public interface UserService {

	public User doLogin(String userName, String password, String userRole);

	public User saveUser(User user);

	public List<User> getAllUser();
	
	public List<User> getAllUserByRole(String role);

	public User getUserById(int userId);

	public User updateUser(User user);

	public void deleteUserById(int userId);

}
