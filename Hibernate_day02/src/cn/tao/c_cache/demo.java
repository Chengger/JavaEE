package cn.tao.c_cache;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.tao.HibernateUtils.HibernateUtils;
import cn.tao.domain.Customer;
//����һ������
public class demo {
	@Test
	//����һ���������
	public void fun1(){
		//1���session
		Session session = HibernateUtils.openSession();
		//2��������
		Transaction tx = session.beginTransaction();
		//3ִ�в���
		Customer c1 = session.get(Customer.class, 1l);//�־û�״̬
		Customer c2 = session.get(Customer.class, 1l);
		Customer c3 = session.get(Customer.class, 1l);
		Customer c4 = session.get(Customer.class, 1l);
		
		System.out.println(c3==c2);
		//4�ύ���񣬹ر���Դ
		tx.commit();
		session.close();//����|�й�״̬,��id,û�й���
	}
	
	@Test
	//�־û�״̬������ʵ���Ƿ���session�����еĶ���
	public void fun2(){
		//1���session
		Session session = HibernateUtils.openSession();
		//2��������
		Transaction tx = session.beginTransaction();
		//3ִ�в���
		Customer c1 = new Customer();
		c1.setCust_id(1l);
		
		session.update(c1);
		
		//4�ύ���񣬹ر���Դ
		tx.commit();
		session.close();//����|�й�״̬,��id,û�й���
	}
}
