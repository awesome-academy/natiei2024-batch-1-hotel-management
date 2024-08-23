package com.spring.sample.service.imp;

import java.util.List;

import com.spring.sample.entity.Permission;
import com.spring.sample.service.PermissionService;

public class PermissionServiceImp extends BaseServiceImpl implements PermissionService {
	private PermissionServiceImp() {
	}

	@Override
	public List<Permission> getAllPermissions() {
		return permissionDAO.getAllPermissions();
	}

	@Override
	public Permission findById(int roleId) {
			return permissionDAO.findById(roleId);
	}

	@Override
	public void save(Permission permission) {
		permissionDAO.save(permission);
	}
}
