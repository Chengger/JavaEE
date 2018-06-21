package cn.tao.c_cache;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.tao.HibernateUtils.HibernateUtils;
import cn.tao.domain.Customer;
//测试一级缓存
public class demo {
	@Test
	//测试一级缓存存在
	public void fun1(){
		//1获得session
		Session session = HibernateUtils.openSession();
		//2控制事务
		Transaction tx = session.beginTransaction();
		//3执行操作
		Customer c1 = session.get(Customer.class, 1l);//持久化状态
		Customer c2 = session.get(Customer.class, 1l);
		Customer c3 = session.get(Customer.class, 1l);
		Customer c4 = session.get(Customer.class, 1l);
		
		System.out.println(c3==c2);
		//4提交事务，关闭资源
		tx.commit();
		session.close();//游离|托管状态,有id,没有关联
	}
	
	@Test
	//持久化状态对象其实就是放入session缓存中的对象
	public void fun2(){
		//1获得session
		Session session = HibernateUtils.openSession();
		//2控制事务
		Transaction tx = session.beginTransaction();
		//3执行操作
		Customer c1 = new Customer();
		c1.setCust_id(1l);
		
		session.update(c1);
		
		//4提交事务，关闭资源
		tx.commit();
		session.close();//游离|托管状态,有id,没有关联
	}
}
