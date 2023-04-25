package com.jbk.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.UserDao;
import com.jbk.entity.User;
import com.jbk.service.UserService;

@Service
public class UserServiceIMPL implements UserService {

	@Autowired
	private UserDao dao;

	@Override
	public User login(User user) {
		return dao.login(user);
	}

	@Override
	public boolean addUser(User user) {
		return dao.addUser(user);
	}

	@Override
	public List<User> allUser() {
		return dao.allUser();
	}

}
