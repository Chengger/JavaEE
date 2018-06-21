package cn.tao.a_hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.tao.HibernateUtils.HibernateUtils;
import cn.tao.domain.Customer;

//学习HQL语法
public class Demo {
	
	//基本语法
	@Test
	public void fun1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//----------------------------------------------------
		String hql = " from  cn.tao.domain.Customer ";//完整写法
		String hql2 = " from  Customer "; //简单写法
		String hql3 = " from java.lang.Object "; 
		
		Query query = session.createQuery(hql2);
		
		List<Customer> list = query.list();
		
		System.out.println(list);
		//----------------------------------------------------
		tx.commit();
		session.close();
		
	}
	
	
	@Test
	//排序
	public void fun2(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//----------------------------------------------------
		String hql1 = " from  cn.tao.domain.Customer order by cust_id asc ";//完整写法
		String hql2 = " from  cn.tao.domain.Customer order by cust_id desc ";//完整写法
		
		Query query = session.createQuery(hql2);
		
		List list = query.list();
		
		System.out.println(list);
		//----------------------------------------------------
		tx.commit();
		session.close();
		
	}

	@Test
	//条件查询
	public void fun3(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//----------------------------------------------------
		String hql1 = " from  cn.tao.domain.Customer where cust_id =? ";//完整写法
		String hql2 = " from  cn.tao.domain.Customer where cust_id = :id ";//完整写法
		
		Query query = session.createQuery(hql2);
		
//		query.setParameter(0, 2l);
		query.setParameter("id", 2l);
		
		
		List list = query.list();
		
		System.out.println(list);
		//----------------------------------------------------
		tx.commit();
		session.close();
		
	}
	
	@Test
	//分页查询
	public void fun4(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//----------------------------------------------------
		String hql1 = " from  cn.tao.domain.Customer  ";//完整写法
		
		Query query = session.createQuery(hql1);
		
		//limit ?,?
		// (当前页数-1)*每页条数
		query.setFirstResult(1);//从第几条数据开始查询（0，1，2，...）
		query.setMaxResults(3);//查询几条数据
		
		List list = query.list();
		
		System.out.println(list);
		//----------------------------------------------------
		tx.commit();
		session.close();
		
	}
	
	@Test
	//统计查询
	//count	计数
	//sum 	求和
	//avg	平均数
	//max
	//min
	public void fun5(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//----------------------------------------------------
		String hql1 = " select count(*) from  cn.tao.domain.Customer  ";//完整写法
		String hql2 = " select sum(cust_id) from  cn.tao.domain.Customer  ";//完整写法
		String hql3 = " select avg(cust_id) from  cn.tao.domain.Customer  ";//完整写法
		String hql4 = " select max(cust_id) from  cn.tao.domain.Customer  ";//完整写法
		String hql5 = " select min(cust_id) from  cn.tao.domain.Customer  ";//完整写法
		
		Query query = session.createQuery(hql4);
		
		Number number  = (Number) query.uniqueResult();
		
		System.out.println(number);
		//----------------------------------------------------
		tx.commit();
		session.close();
		
	}
	
	
	@Test
	//投影查询
	public void fun6(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//----------------------------------------------------
		String hql1 = " select cust_name from  cn.tao.domain.Customer  ";
		String hql2 = " select cust_name,cust_id from  cn.tao.domain.Customer  ";
		String hql3 = " select new Customer(cust_id,cust_name) from  cn.tao.domain.Customer  ";
		
		Query query = session.createQuery(hql3);
		
		List list = query.list();
		
		System.out.println(list);
		
		//----------------------------------------------------
		tx.commit();
		session.close();
		
	}
}

