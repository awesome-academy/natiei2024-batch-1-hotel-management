package com.spring.sample.dao;

import java.util.List;

import com.spring.sample.entity.Permission;

public interface PermissionDAO {

	List<Permission> getAllPermissions();

	Permission findById(int roleId);

	void save(Permission permission);
}
