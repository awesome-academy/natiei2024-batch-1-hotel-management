package com.spring.sample.service;

import java.util.List;

import com.spring.sample.entity.Permission;

public interface PermissionService {

	List<Permission> getAllPermissions();

	Permission findById(int roleId);

	void save(Permission permission);

}
