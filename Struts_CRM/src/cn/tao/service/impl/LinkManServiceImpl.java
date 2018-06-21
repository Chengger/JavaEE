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
		//������
		HibernateUtils.getCurrentSession().beginTransaction();
		
		try {
			//1 ���ݿͻ�id��ÿͻ�����
			Long cust_id = lm.getCust_id();
			Customer c = cd.getById(cust_id);
			//2 ���ͻ�����LinkMan�б���ϵ
			lm.setCustomer(c);
			//3 ����LinkMan
			lmd.save(lm);
		} catch (Exception e) {
			e.printStackTrace();
			//�ع�����
			HibernateUtils.getCurrentSession().getTransaction().rollback();
		}
		//�ύ����
		HibernateUtils.getCurrentSession().getTransaction().commit();
		
	}
	@Override
	public List<LinkMan> getAll(DetachedCriteria dc) {
		Session session =  HibernateUtils.getCurrentSession();
		//������
		Transaction tx = session.beginTransaction();
		
		List<LinkMan> list = lmd.getAll(dc);
		
		
		//�ر�����
		tx.commit();
		return list;
	}
}
