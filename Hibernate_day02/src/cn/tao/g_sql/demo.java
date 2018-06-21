package cn.tao.g_sql;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import cn.tao.HibernateUtils.HibernateUtils;
import cn.tao.domain.Customer;
//测试原生sql查询
public class demo {
	@Test
	//基本查询
	public void fun1(){
		//1获得session
		Session session = HibernateUtils.openSession();
		//2控制事务
		Transaction tx = session.beginTransaction();
		//3执行操作
		//1>书写sql语句
		String sql = "select * from cst_customer";
		//2>创建sql查询对象
		SQLQuery query = session.createSQLQuery(sql);
		//3>调用方法查询结果
		List<Object[]> list = query.list();
		for (Object[] objects : list) {
			System.out.println(Arrays.toString(objects));
		}
		//4提交事务，关闭资源
		tx.commit();
		session.close();//游离|托管状态,有id,没有关联
	}
	@Test
	
	public void fun2(){
		//1获得session
		Session session = HibernateUtils.openSession();
		//2控制事务
		Transaction tx = session.beginTransaction();
		//3执行操作
		//1>书写sql语句
		String sql = "select * from cst_customer";
		//2>创建sql查询对象
		SQLQuery query = session.createSQLQuery(sql);
		//指定将结果集封装到哪个对象中
		query.addEntity(Customer.class);
		//3>调用方法查询结果
		List<Customer> list = query.list();
		System.out.println(list);
		//4提交事务，关闭资源
		tx.commit();
		session.close();//游离|托管状态,有id,没有关联
	}
	@Test
	//条件查询
	public void fun3(){
		//1获得session
		Session session = HibernateUtils.openSession();
		//2控制事务
		Transaction tx = session.beginTransaction();
		//3执行操作
		//1>书写sql语句
		String sql = "select * from cst_customer where cust_id = ?";
		//2>创建sql查询对象
		SQLQuery query = session.createSQLQuery(sql);
		//指定将结果集封装到哪个对象中
		query.setParameter(0, 1l);
		query.addEntity(Customer.class);
		//3>调用方法查询结果
		Customer c =  (Customer) query.uniqueResult();
		System.out.println(c);
		//4提交事务，关闭资源
		tx.commit();
		session.close();//游离|托管状态,有id,没有关联
	}
	@Test
	//分页查询
	public void fun4(){
		//1获得session
		Session session = HibernateUtils.openSession();
		//2控制事务
		Transaction tx = session.beginTransaction();
		//3执行操作
		//1>书写sql语句
		String sql = "select * from cst_customer limit ?,?";
		//2>创建sql查询对象
		SQLQuery query = session.createSQLQuery(sql);
		//指定将结果集封装到哪个对象中
		query.setParameter(0, 0);
		query.setParameter(1, 2);
		query.addEntity(Customer.class);
		//3>调用方法查询结果
		 List<Customer> list = query.list();
		System.out.println(list);
		//4提交事务，关闭资源
		tx.commit();
		session.close();//游离|托管状态,有id,没有关联
	}
}
