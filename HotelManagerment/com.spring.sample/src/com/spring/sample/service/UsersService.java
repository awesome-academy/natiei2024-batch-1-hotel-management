package com.spring.sample.service;

import java.util.List;

import com.spring.sample.entity.Users;

public interface UsersService {

	List<Users> getAllUsers();

	void deleteByUserName(String username);

	void save(Users newUser);

	Users findByUsername(String username);

	Users isValidUser(String email, String password);

}
