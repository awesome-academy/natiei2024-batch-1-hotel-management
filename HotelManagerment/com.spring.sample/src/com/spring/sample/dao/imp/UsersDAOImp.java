package com.spring.sample.dao.imp;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.query.Query;

import com.spring.sample.dao.UsersDAO;
import com.spring.sample.entity.Users;

public class UsersDAOImp extends GenericDAOImp<Users, Integer> implements UsersDAO {
	public UsersDAOImp() {
		super(Users.class);
	}

	@Override
	public List<Users> getAllUsers() {
		String hql = "SELECT r FROM USERS r LEFT JOIN FETCH r.permission t";
		Query<Users> query = getSession().createQuery(hql, Users.class);
		return query.getResultList();

	}

	@Override
	public void deleteByUserName(String username) {
	    // Tải thực thể Users bằng username
	    Users users = getHibernateTemplate().get(Users.class, username);
	    
	    // Kiểm tra xem thực thể có tồn tại không
	    if (users == null) {
	        throw new RuntimeException("Users not found for username: " + username);
	    }

	    // Khóa thực thể (có thể dùng LockMode nếu cần)
	    getSession().buildLockRequest(LockOptions.NONE).lock(users);

	    // Xóa thực thể
	    getHibernateTemplate().delete(users);
	}

	@Override
	public void save(Users newUser) {
		getHibernateTemplate().saveOrUpdate(newUser);
		
	}

	@Override
    public Users findByUsername(String username) {
        String hql = "FROM USERS u WHERE u.username = :username";  // Use the correct entity name
        Query<Users> query = getSession().createQuery(hql, Users.class);
        query.setParameter("username", username);
        List<Users> result = query.getResultList();
        return result.isEmpty() ? null : result.get(0);  
    }

}
