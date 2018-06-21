package cn.tao.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import cn.tao.Utils.HibernateUtils;
import cn.tao.dao.CustomerDao;
import cn.tao.domain.Customer;

public class CustomerDaoImpl implements CustomerDao {
	@Override
	public void save(Customer c) {
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		session.save(c);
		tx.commit();
		
		session.close();
	}

	@Override
	public List<Customer> getAll() {
		Session session = HibernateUtils.openSession();
		Criteria c = session.createCriteria(Customer.class);
		return c.list();
	}

	@Override
	public Customer getById(Long cust_id) {
		//1 获得session
		Session session = HibernateUtils.getCurrentSession();
		return session.get(Customer.class, cust_id);
	}

	@Override
	public List<Customer> getAll(DetachedCriteria dc) {
		//1获得session
		Session session = HibernateUtils.openSession();
		//2将离线对象关联到session
		Criteria c = dc.getExecutableCriteria(session);
		//3执行查询并返回
		return c.list();
	}

}
