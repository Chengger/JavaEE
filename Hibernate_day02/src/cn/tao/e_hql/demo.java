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
//����getcurrentSession
public class demo {
	@Test
	//������ѯ
	public void fun1(){
		//1���session
		Session session = HibernateUtils.openSession();
		//2��������
		Transaction tx = session.beginTransaction();
		//3ִ�в���
		//1>��дHQL���
		
		//String hql = "select * from �������������";
		String hql = "from Customer";//��ѯ����Customer����
		//2>����HQL��䴴����ѯ����
		Query query = session.createQuery(hql);
		//3>���ݲ�ѯ�����ò�ѯ���
		List<Customer> list = query.list();//����list���
		//query.uniqueResult();//����Ψһ�Ĳ�ѯ���
		System.out.println(list);
		//4�ύ���񣬹ر���Դ
		tx.commit();
		session.close();//����|�й�״̬,��id,û�й���
	}
	@Test
	//������ѯ
	//hql����У������ܳ����κ����ݿ���ص���Ϣ
	public void fun2(){
		//1���session
		Session session = HibernateUtils.openSession();
		//2��������
		Transaction tx = session.beginTransaction();
		//3ִ�в���
		//1>��дHQL���
		
		//String hql = "select * from �������������";
		String hql = "from Customer where Cust_id = 1";//��ѯ����Customer����
		//2>����HQL��䴴����ѯ����
		Query query = session.createQuery(hql);
		//3>���ݲ�ѯ�����ò�ѯ���
		Customer c = (Customer) query.uniqueResult();//����Ψһ�Ĳ�ѯ���
		System.out.println(c);
		//4�ύ���񣬹ر���Դ
		tx.commit();
		session.close();//����|�й�״̬,��id,û�й���
	}
	@Test
	//������ѯ
	//�ʺ�ռλ��
	public void fun3(){
		//1���session
		Session session = HibernateUtils.openSession();
		//2��������
		Transaction tx = session.beginTransaction();
		//3ִ�в���
		//1>��дHQL���
		
		//String hql = "select * from �������������";
		String hql = "from Customer where Cust_id = ?";//��ѯ����Customer����
		//2>����HQL��䴴����ѯ����
		Query query = session.createQuery(hql);
		//3>���ݲ�ѯ�����ò�ѯ���
		//���ò���
		//query.setLong(0, 1l);
		query.setParameter(0, 1l);
		Customer c = (Customer) query.uniqueResult();//����Ψһ�Ĳ�ѯ���
		System.out.println(c);
		//4�ύ���񣬹ر���Դ
		tx.commit();
		session.close();//����|�й�״̬,��id,û�й���
	}
	
	@Test
	//������ѯ
	//����ռλ��
	public void fun4(){
		//1���session
		Session session = HibernateUtils.openSession();
		//2��������
		Transaction tx = session.beginTransaction();
		//3ִ�в���
		//1>��дHQL���
		
		//String hql = "select * from �������������";
		String hql = "from Customer where Cust_id = :cust_id";//��ѯ����Customer����
		//2>����HQL��䴴����ѯ����
		Query query = session.createQuery(hql);
		//3>���ݲ�ѯ�����ò�ѯ���
		//���ò���
		//query.setLong(0, 1l);
		query.setParameter("cust_id", 2l);
		Customer c = (Customer) query.uniqueResult();//����Ψһ�Ĳ�ѯ���
		System.out.println(c);
		//4�ύ���񣬹ر���Դ
		tx.commit();
		session.close();//����|�й�״̬,��id,û�й���
	}
	
	@Test
	//��ҳ��ѯ
	public void fun5(){
		//1���session
		Session session = HibernateUtils.openSession();
		//2��������
		Transaction tx = session.beginTransaction();
		//3ִ�в���
		//1>��дHQL���
		
		//String hql = "select * from �������������";
		String hql = "from Customer ";//��ѯ����Customer����
		//2>����HQL��䴴����ѯ����
		Query query = session.createQuery(hql);
		//3>���ݲ�ѯ�����ò�ѯ���
		//���÷�ҳ��Ϣ limit ?,?
		query.setFirstResult(1);
		query.setMaxResults(1);
		List<Customer> c =  query.list();//����Ψһ�Ĳ�ѯ���
		System.out.println(c);
		//4�ύ���񣬹ر���Դ
		tx.commit();
		session.close();//����|�й�״̬,��id,û�й���
	}
}
