package cn.tao.a_generator;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.tao.HibernateUtils.HibernateUtils;
import cn.tao.domain.Customer;

public class demo {
	@Test
	//������������
	public void fun1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		Customer c = new Customer();
		c.setCust_name("��Ϊ");
		
		session.save(c);
		
		tx.commit();
		session.close();
	}
}
