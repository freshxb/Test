package com.xiongbo.user.dao;

import org.hibernate.Session;

import com.xiongbo.user.User;
import com.xiongbo.user.util.HibernateUtil;

public class UserDao implements IUserDao {
	public void add(User user) {
		Session session = HibernateUtil.openSession();
		try {
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
		}
	}

	public User loadByUsername(String username) {
		Session session = HibernateUtil.openSession();
		User user = null;
		try {
			session.beginTransaction();
			user = (User) session.createQuery("from User where username = ?").setParameter(0, username).uniqueResult();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
		}

		return user;
	}

}
