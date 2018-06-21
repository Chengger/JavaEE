package cn.tao.f_criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
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
		Criteria criteria = session.createCriteria(Customer.class);//查询所有的customer对象
		
		List<Customer> list = criteria.list();
		
		//Customer c = (Customer) criteria.uniqueResult();
		System.out.println(list);
		//4提交事务，关闭资源
		tx.commit();
		session.close();//游离|托管状态,有id,没有关联
	}
	@Test
	//条件查询
	//hql语句中，不可能出现任何数据库相关的信息
	//>				gt
	//<				ge
	//>=			lt
	//<=			le
	//!=			ne
	//==			eq
	//in			in
	//between and	between
	//like			like
	//is not null	isNotNull
	//is null		isNull
	//or			or
	//and			and
	public void fun2(){
		//1获得session
		Session session = HibernateUtils.openSession();
		//2控制事务
		Transaction tx = session.beginTransaction();
		//3执行操作
		Criteria criteria = session.createCriteria(Customer.class);//查询所有的customer对象
		
		//添加查询参数=>c查询cust_id为1的customer对象
		criteria.add(Restrictions.eq("cust_id", 1l));
		Customer c = (Customer) criteria.uniqueResult();
		System.out.println(c);
		//4提交事务，关闭资源
		tx.commit();
		session.close();//游离|托管状态,有id,没有关联
	}
	@Test
	//分页查询
	public void fun3(){
		//1获得session
		Session session = HibernateUtils.openSession();
		//2控制事务
		Transaction tx = session.beginTransaction();
		//3执行操作
		Criteria criteria = session.createCriteria(Customer.class);
		//limit
		criteria.setFirstResult(1);
		criteria.setMaxResults(2);
		List<Customer> list = criteria.list();
		System.out.println(list);
		//4提交事务，关闭资源
		tx.commit();
		session.close();//游离|托管状态,有id,没有关联
	}
	
	@Test
	//查询总记录数
	public void fun4(){
		//1获得session
		Session session = HibernateUtils.openSession();
		//2控制事务
		Transaction tx = session.beginTransaction();
		//3执行操作
		Criteria criteria = session.createCriteria(Customer.class);
		//设置查询的聚合函数=>总行数
		criteria.setProjection(Projections.rowCount());
		Long c = (Long) criteria.uniqueResult();
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
