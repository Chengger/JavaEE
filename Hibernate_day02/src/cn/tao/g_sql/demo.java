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
//����ԭ��sql��ѯ
public class demo {
	@Test
	//������ѯ
	public void fun1(){
		//1���session
		Session session = HibernateUtils.openSession();
		//2��������
		Transaction tx = session.beginTransaction();
		//3ִ�в���
		//1>��дsql���
		String sql = "select * from cst_customer";
		//2>����sql��ѯ����
		SQLQuery query = session.createSQLQuery(sql);
		//3>���÷�����ѯ���
		List<Object[]> list = query.list();
		for (Object[] objects : list) {
			System.out.println(Arrays.toString(objects));
		}
		//4�ύ���񣬹ر���Դ
		tx.commit();
		session.close();//����|�й�״̬,��id,û�й���
	}
	@Test
	
	public void fun2(){
		//1���session
		Session session = HibernateUtils.openSession();
		//2��������
		Transaction tx = session.beginTransaction();
		//3ִ�в���
		//1>��дsql���
		String sql = "select * from cst_customer";
		//2>����sql��ѯ����
		SQLQuery query = session.createSQLQuery(sql);
		//ָ�����������װ���ĸ�������
		query.addEntity(Customer.class);
		//3>���÷�����ѯ���
		List<Customer> list = query.list();
		System.out.println(list);
		//4�ύ���񣬹ر���Դ
		tx.commit();
		session.close();//����|�й�״̬,��id,û�й���
	}
	@Test
	//������ѯ
	public void fun3(){
		//1���session
		Session session = HibernateUtils.openSession();
		//2��������
		Transaction tx = session.beginTransaction();
		//3ִ�в���
		//1>��дsql���
		String sql = "select * from cst_customer where cust_id = ?";
		//2>����sql��ѯ����
		SQLQuery query = session.createSQLQuery(sql);
		//ָ�����������װ���ĸ�������
		query.setParameter(0, 1l);
		query.addEntity(Customer.class);
		//3>���÷�����ѯ���
		Customer c =  (Customer) query.uniqueResult();
		System.out.println(c);
		//4�ύ���񣬹ر���Դ
		tx.commit();
		session.close();//����|�й�״̬,��id,û�й���
	}
	@Test
	//��ҳ��ѯ
	public void fun4(){
		//1���session
		Session session = HibernateUtils.openSession();
		//2��������
		Transaction tx = session.beginTransaction();
		//3ִ�в���
		//1>��дsql���
		String sql = "select * from cst_customer limit ?,?";
		//2>����sql��ѯ����
		SQLQuery query = session.createSQLQuery(sql);
		//ָ�����������װ���ĸ�������
		query.setParameter(0, 0);
		query.setParameter(1, 2);
		query.addEntity(Customer.class);
		//3>���÷�����ѯ���
		 List<Customer> list = query.list();
		System.out.println(list);
		//4�ύ���񣬹ر���Դ
		tx.commit();
		session.close();//����|�й�״̬,��id,û�й���
	}
}
