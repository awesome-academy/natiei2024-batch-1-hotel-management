package com.spring.sample.dao;

import java.util.List;

import com.spring.sample.entity.Users;

public interface UsersDAO {

	List<Users> getAllUsers();

	public void deleteByUserName(String username);

	void save(Users newUser);

	Users findByUsername(String username);

	Users isValidUser(String email, String password);

}
