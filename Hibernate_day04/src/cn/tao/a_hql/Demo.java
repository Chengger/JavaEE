package cn.tao.a_hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.tao.HibernateUtils.HibernateUtils;
import cn.tao.domain.Customer;

//ѧϰHQL�﷨
public class Demo {
	
	//�����﷨
	@Test
	public void fun1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//----------------------------------------------------
		String hql = " from  cn.tao.domain.Customer ";//����д��
		String hql2 = " from  Customer "; //��д��
		String hql3 = " from java.lang.Object "; 
		
		Query query = session.createQuery(hql2);
		
		List<Customer> list = query.list();
		
		System.out.println(list);
		//----------------------------------------------------
		tx.commit();
		session.close();
		
	}
	
	
	@Test
	//����
	public void fun2(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//----------------------------------------------------
		String hql1 = " from  cn.tao.domain.Customer order by cust_id asc ";//����д��
		String hql2 = " from  cn.tao.domain.Customer order by cust_id desc ";//����д��
		
		Query query = session.createQuery(hql2);
		
		List list = query.list();
		
		System.out.println(list);
		//----------------------------------------------------
		tx.commit();
		session.close();
		
	}

	@Test
	//������ѯ
	public void fun3(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//----------------------------------------------------
		String hql1 = " from  cn.tao.domain.Customer where cust_id =? ";//����д��
		String hql2 = " from  cn.tao.domain.Customer where cust_id = :id ";//����д��
		
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
	//��ҳ��ѯ
	public void fun4(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//----------------------------------------------------
		String hql1 = " from  cn.tao.domain.Customer  ";//����д��
		
		Query query = session.createQuery(hql1);
		
		//limit ?,?
		// (��ǰҳ��-1)*ÿҳ����
		query.setFirstResult(1);//�ӵڼ������ݿ�ʼ��ѯ��0��1��2��...��
		query.setMaxResults(3);//��ѯ��������
		
		List list = query.list();
		
		System.out.println(list);
		//----------------------------------------------------
		tx.commit();
		session.close();
		
	}
	
	@Test
	//ͳ�Ʋ�ѯ
	//count	����
	//sum 	���
	//avg	ƽ����
	//max
	//min
	public void fun5(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//----------------------------------------------------
		String hql1 = " select count(*) from  cn.tao.domain.Customer  ";//����д��
		String hql2 = " select sum(cust_id) from  cn.tao.domain.Customer  ";//����д��
		String hql3 = " select avg(cust_id) from  cn.tao.domain.Customer  ";//����д��
		String hql4 = " select max(cust_id) from  cn.tao.domain.Customer  ";//����д��
		String hql5 = " select min(cust_id) from  cn.tao.domain.Customer  ";//����д��
		
		Query query = session.createQuery(hql4);
		
		Number number  = (Number) query.uniqueResult();
		
		System.out.println(number);
		//----------------------------------------------------
		tx.commit();
		session.close();
		
	}
	
	
	@Test
	//ͶӰ��ѯ
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

