package com.jbk.daoImpl;

import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.dao.UserDao;
import com.jbk.entity.User;

@Repository
public class UserDaoIMPL implements UserDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public User login(User user) {
		Session session = null;
		User dbUser = null;
		try {
			session = sf.openSession();
			dbUser = session.get(User.class, user.getUsername());
			if (dbUser != null) {

				if (user.getPassword().equals(dbUser.getPassword())) {
					return dbUser;
				} else {
					dbUser = null;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return dbUser;

	}

	@Override
	public boolean addUser(User user) {
		boolean isAdded = false;
		Session session = null;
		try {
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
			isAdded = true;
		} catch (PersistenceException e) {
			isAdded = false;
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return isAdded;

	}

	@Override
	public List<User> allUser() {
		Session session = null;
		List<User> list = null;
		try {
			session = sf.openSession();
			Criteria criteria = session.createCriteria(User.class);
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

}
