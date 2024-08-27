package com.spring.sample.dao.imp;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.spring.sample.dao.PermissionDAO;
import com.spring.sample.entity.Permission;

@Repository
public class PermissionDAOImp extends GenericDAOImp<Permission, Integer> implements PermissionDAO {

    public PermissionDAOImp() {
        super(Permission.class);
    }

    @Override
    public List<Permission> getAllPermissions() {
        String hql = "FROM PERMISSIONS r"; // Corrected HQL syntax
        Query<Permission> query = getSession().createQuery(hql, Permission.class);
        return query.getResultList();
    }

    @Override
    public Permission findById(int permissionID) {
        String hql = "FROM PERMISSIONS p WHERE p.permissionID = :permissionID";
        Query<Permission> query = getSession().createQuery(hql, Permission.class);
        query.setParameter("permissionID", permissionID);
        return query.uniqueResult();
    }

    @Override
    public void save(Permission permission) {
        getSession().saveOrUpdate(permission); // Spring will handle transaction boundaries
    }
}
