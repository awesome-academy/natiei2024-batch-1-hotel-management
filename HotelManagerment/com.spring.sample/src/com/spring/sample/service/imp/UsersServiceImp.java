package com.spring.sample.service.imp;

import java.util.List;

import com.spring.sample.entity.Users;
import com.spring.sample.service.UsersService;

public class UsersServiceImp extends BaseServiceImpl implements UsersService {
	private UsersServiceImp() {
	}

	@Override
	public List<Users> getAllUsers() {
		return usersDAO.getAllUsers();
	}

	@Override
	public void deleteByUserName(String username) {
		usersDAO.deleteByUserName(username);
	}

	@Override
	public void save(Users newUser) {
		usersDAO.save(newUser);
	}

	@Override
	public Users findByUsername(String username) {
		return usersDAO.findByUsername(username);
	}
}	