package com.spring.sample.dao.imp;

import com.spring.sample.dao.UsersDAO;
import com.spring.sample.entity.Users;

public class UsersDAOImp extends GenericDAOImp<Users, Integer> implements UsersDAO {
	public UsersDAOImp() {
		super(Users.class);
	}
}
