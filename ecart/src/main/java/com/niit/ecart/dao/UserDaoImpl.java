package com.niit.ecart.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ecart.model.User;





@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.openSession();
	}

	
	public User getUsersById(String userId) {
		// TODO Auto-generated method stub
		Session session = getSession();
		return (User) session.get(User.class, userId);
	}

	public List<User> getAllUsers(String un) {
		// TODO Auto-generated method stub
		Session session = getSession();

		Query query = session.createQuery("from User where userName != :un");
		query.setParameter("un", un);
		List<User> customerList = query.list();

		return customerList;

	}

	public User getUsersByUsername(String userName) {
		// TODO Auto-generated method stub
		Session session = getSession();

		Query query = session.createQuery("from User where username = ?");
		query.setString(0, userName);

		return (User) query.uniqueResult();

	}

	
		
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		Session session=getSession();
		try{
			session.delete(user);
			return true;
		}catch(HibernateException e){
			e.printStackTrace();
			return false;
		}
		finally{
			session.flush();
			session.close();
		}
	}

	public boolean editUsers(User users) {
		// TODO Auto-generated method stub
		Session session=getSession();
		try{
			session.save(users);
			return true;
		}catch(HibernateException e){
			e.printStackTrace();
			return false;
		}
		finally{
			session.flush();
			session.close();
		}
	}

	public boolean addUsers(User users) {
		// TODO Auto-generated method stub
		Session session=getSession();
		try{
			session.save(users);
			return true;
		}catch(HibernateException e){
			e.printStackTrace();
			return false;
		}
		finally{
			session.flush();
			session.close();
		}
	}
}