package cn.tao.d_tx;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.tao.HibernateUtils.HibernateUtils;
import cn.tao.domain.Customer;
//测试getcurrentSession
public class demo {
	@Test

	public void fun1(){
		//1获得session
		Session session1 = HibernateUtils.getCurrentSession();
		Session session2 = HibernateUtils.getCurrentSession();
		
		
		System.out.println(session1==session2);
	}
	@Test
	public void fun2(){
		//1获得session
		Session session1 = HibernateUtils.openSession();
		Session session2 = HibernateUtils.openSession();
		
		
		System.out.println(session1==session2);
	}
	
}
