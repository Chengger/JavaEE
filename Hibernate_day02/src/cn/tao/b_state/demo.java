package cn.tao.b_state;

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
	//测试主键生成
	public void fun1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		Customer c = new Customer();//没有id,没有与session关联=>瞬时状态
		c.setCust_name("华为");//瞬时状态
		
		session.save(c);//持久化状态,有id,有关联
		
		tx.commit();
		session.close();//游离|托管状态,有id,没有关联
	}
	
	@Test
	//三种状态特点
	//save方法:其实不能理解成保存，理解成将瞬时状态转换为持久化状态
	//主键自增:执行save方法时，为了将对象转换为持久化状态
	//increment:执行save方法,为了生成id,会执行查询id最大值的sql语句
	public void fun2(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		Customer c = new Customer();//没有id,没有与session关联=>瞬时状态
		c.setCust_name("华为");//瞬时状态
		
		session.save(c);//持久化状态,有id,有关联
		
		tx.commit();
		session.close();//游离|托管状态,有id,没有关联
	}
	
	
	@Test
	//三种状态特点
	//持久化状态特点:持久化状态对象的任何变化都会自动同步到数据库中
	public void fun3(){
		//1获得session
		Session session = HibernateUtils.openSession();
		//2控制事务
		Transaction tx = session.beginTransaction();
		//3执行操作
		Customer c = session.get(Customer.class, 1l);//持久化状态
		c.setCust_name("apple");
		//4提交事务，关闭资源
		tx.commit();
		session.close();//游离|托管状态,有id,没有关联
	}
}
