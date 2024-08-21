package com.spring.sample.dao.imp;

import com.spring.sample.dao.PermissionDAO;
import com.spring.sample.entity.Permission;

public class PermissionDAOImp extends GenericDAOImp<Permission, Integer> implements PermissionDAO {

	public PermissionDAOImp() {
		super(Permission.class);
	}

}
