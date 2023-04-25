package com.jbk.dao;

import java.util.List;

import com.jbk.entity.User;

public interface UserDao {
	public User login(User user);
	public boolean addUser(User user);
	public List<User> allUser();

}
