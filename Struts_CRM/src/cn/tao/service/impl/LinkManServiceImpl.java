package cn.tao.service.impl;

import cn.tao.dao.CustomerDao;
import cn.tao.dao.LinkManDao;
import cn.tao.dao.impl.CustomerDaoImpl;
import cn.tao.dao.impl.LinkManDaoImpl;
import cn.tao.domain.Customer;
import cn.tao.domain.LinkMan;
import cn.tao.service.LinkManService;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import cn.tao.Utils.HibernateUtils;

public class LinkManServiceImpl implements LinkManService {

	private CustomerDao cd =new CustomerDaoImpl();
	private LinkManDao lmd = new LinkManDaoImpl();
	public void save(LinkMan lm) {
		//打开事务
		HibernateUtils.getCurrentSession().beginTransaction();
		
		try {
			//1 根据客户id获得客户对象
			Long cust_id = lm.getCust_id();
			Customer c = cd.getById(cust_id);
			//2 将客户放入LinkMan中表达关系
			lm.setCustomer(c);
			//3 保存LinkMan
			lmd.save(lm);
		} catch (Exception e) {
			e.printStackTrace();
			//回滚事务
			HibernateUtils.getCurrentSession().getTransaction().rollback();
		}
		//提交事务
		HibernateUtils.getCurrentSession().getTransaction().commit();
		
	}
	@Override
	public List<LinkMan> getAll(DetachedCriteria dc) {
		Session session =  HibernateUtils.getCurrentSession();
		//打开事务
		Transaction tx = session.beginTransaction();
		
		List<LinkMan> list = lmd.getAll(dc);
		
		
		//关闭事务
		tx.commit();
		return list;
	}
}
