package cn.tao.a_hello;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.tao.domain.Customer;

public class demo {
	@Test
	//����ͻ�
	public void fun1(){
		Configuration conf = new Configuration().configure();
		
		SessionFactory sessionFactory = conf.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
	
		Transaction tx = session.beginTransaction();
		//----------------------------------------------
		Customer c = new Customer();
		c.setCust_name("google��˾");
		
		session.save(c);//ִ�б���
		
		//----------------------------------------------
		tx.commit();
		session.close();
		sessionFactory.close();
	}
}