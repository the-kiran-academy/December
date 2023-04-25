package com.jbk.service;

import java.util.List;

import com.jbk.entity.User;

public interface UserService {
	
	public User login(User user);
	public boolean addUser(User user);
	public List<User> allUser();
}
