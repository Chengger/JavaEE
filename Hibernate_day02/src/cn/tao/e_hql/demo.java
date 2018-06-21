package cn.tao.e_hql;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
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
	//基本查询
	public void fun1(){
		//1获得session
		Session session = HibernateUtils.openSession();
		//2控制事务
		Transaction tx = session.beginTransaction();
		//3执行操作
		//1>书写HQL语句
		
		//String hql = "select * from 对象的完整类名";
		String hql = "from Customer";//查询所有Customer对象
		//2>根据HQL语句创建查询对象
		Query query = session.createQuery(hql);
		//3>根据查询对象获得查询结果
		List<Customer> list = query.list();//返回list结果
		//query.uniqueResult();//接收唯一的查询结果
		System.out.println(list);
		//4提交事务，关闭资源
		tx.commit();
		session.close();//游离|托管状态,有id,没有关联
	}
	@Test
	//条件查询
	//hql语句中，不可能出现任何数据库相关的信息
	public void fun2(){
		//1获得session
		Session session = HibernateUtils.openSession();
		//2控制事务
		Transaction tx = session.beginTransaction();
		//3执行操作
		//1>书写HQL语句
		
		//String hql = "select * from 对象的完整类名";
		String hql = "from Customer where Cust_id = 1";//查询所有Customer对象
		//2>根据HQL语句创建查询对象
		Query query = session.createQuery(hql);
		//3>根据查询对象获得查询结果
		Customer c = (Customer) query.uniqueResult();//接收唯一的查询结果
		System.out.println(c);
		//4提交事务，关闭资源
		tx.commit();
		session.close();//游离|托管状态,有id,没有关联
	}
	@Test
	//条件查询
	//问号占位符
	public void fun3(){
		//1获得session
		Session session = HibernateUtils.openSession();
		//2控制事务
		Transaction tx = session.beginTransaction();
		//3执行操作
		//1>书写HQL语句
		
		//String hql = "select * from 对象的完整类名";
		String hql = "from Customer where Cust_id = ?";//查询所有Customer对象
		//2>根据HQL语句创建查询对象
		Query query = session.createQuery(hql);
		//3>根据查询对象获得查询结果
		//设置参数
		//query.setLong(0, 1l);
		query.setParameter(0, 1l);
		Customer c = (Customer) query.uniqueResult();//接收唯一的查询结果
		System.out.println(c);
		//4提交事务，关闭资源
		tx.commit();
		session.close();//游离|托管状态,有id,没有关联
	}
	
	@Test
	//条件查询
	//命名占位符
	public void fun4(){
		//1获得session
		Session session = HibernateUtils.openSession();
		//2控制事务
		Transaction tx = session.beginTransaction();
		//3执行操作
		//1>书写HQL语句
		
		//String hql = "select * from 对象的完整类名";
		String hql = "from Customer where Cust_id = :cust_id";//查询所有Customer对象
		//2>根据HQL语句创建查询对象
		Query query = session.createQuery(hql);
		//3>根据查询对象获得查询结果
		//设置参数
		//query.setLong(0, 1l);
		query.setParameter("cust_id", 2l);
		Customer c = (Customer) query.uniqueResult();//接收唯一的查询结果
		System.out.println(c);
		//4提交事务，关闭资源
		tx.commit();
		session.close();//游离|托管状态,有id,没有关联
	}
	
	@Test
	//分页查询
	public void fun5(){
		//1获得session
		Session session = HibernateUtils.openSession();
		//2控制事务
		Transaction tx = session.beginTransaction();
		//3执行操作
		//1>书写HQL语句
		
		//String hql = "select * from 对象的完整类名";
		String hql = "from Customer ";//查询所有Customer对象
		//2>根据HQL语句创建查询对象
		Query query = session.createQuery(hql);
		//3>根据查询对象获得查询结果
		//设置分页信息 limit ?,?
		query.setFirstResult(1);
		query.setMaxResults(1);
		List<Customer> c =  query.list();//接收唯一的查询结果
		System.out.println(c);
		//4提交事务，关闭资源
		tx.commit();
		session.close();//游离|托管状态,有id,没有关联
	}
}
