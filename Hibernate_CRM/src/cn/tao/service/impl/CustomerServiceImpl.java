package cn.tao.service.impl;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import cn.tao.Utils.HibernateUtils;
import cn.tao.dao.CustomerDao;
import cn.tao.dao.impl.CustomerDaoImpl;
import cn.tao.domain.Customer;
import cn.tao.service.CustomerService;

public  class CustomerServiceImpl implements CustomerService {
	private CustomerDao customerDao = new CustomerDaoImpl();
	@Override
	public void save(Customer c) {
		//调用Dao保存客户
		Session session =  HibernateUtils.getCurrentSession();
		//打开事务
		Transaction tx = session.beginTransaction();
		//调用Dao保存客户
		try {
			customerDao .save(c);
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		//关闭事务
		tx.commit();
	}
	@Override
	public List<Customer> getAll() {
		Session session =  HibernateUtils.getCurrentSession();
		//打开事务
		Transaction tx = session.beginTransaction();
		
		List<Customer> list = customerDao.getAll();
		
		
		//关闭事务
		tx.commit();
		return list;
	}
	@Override
	public List<Customer> getAll(DetachedCriteria dc) {
		Session session =  HibernateUtils.getCurrentSession();
		//打开事务
		Transaction tx = session.beginTransaction();
		
		List<Customer> list = customerDao.getAll(dc);
		
		
		//关闭事务
		tx.commit();
		return list;
	}

}
