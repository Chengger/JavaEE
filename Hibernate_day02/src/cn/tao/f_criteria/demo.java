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
		Criteria criteria = session.createCriteria(Customer.class);//��ѯ���е�customer����
		
		List<Customer> list = criteria.list();
		
		//Customer c = (Customer) criteria.uniqueResult();
		System.out.println(list);
		//4�ύ���񣬹ر���Դ
		tx.commit();
		session.close();//����|�й�״̬,��id,û�й���
	}
	@Test
	//������ѯ
	//hql����У������ܳ����κ����ݿ���ص���Ϣ
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
		//1���session
		Session session = HibernateUtils.openSession();
		//2��������
		Transaction tx = session.beginTransaction();
		//3ִ�в���
		Criteria criteria = session.createCriteria(Customer.class);//��ѯ���е�customer����
		
		//��Ӳ�ѯ����=>c��ѯcust_idΪ1��customer����
		criteria.add(Restrictions.eq("cust_id", 1l));
		Customer c = (Customer) criteria.uniqueResult();
		System.out.println(c);
		//4�ύ���񣬹ر���Դ
		tx.commit();
		session.close();//����|�й�״̬,��id,û�й���
	}
	@Test
	//��ҳ��ѯ
	public void fun3(){
		//1���session
		Session session = HibernateUtils.openSession();
		//2��������
		Transaction tx = session.beginTransaction();
		//3ִ�в���
		Criteria criteria = session.createCriteria(Customer.class);
		//limit
		criteria.setFirstResult(1);
		criteria.setMaxResults(2);
		List<Customer> list = criteria.list();
		System.out.println(list);
		//4�ύ���񣬹ر���Դ
		tx.commit();
		session.close();//����|�й�״̬,��id,û�й���
	}
	
	@Test
	//��ѯ�ܼ�¼��
	public void fun4(){
		//1���session
		Session session = HibernateUtils.openSession();
		//2��������
		Transaction tx = session.beginTransaction();
		//3ִ�в���
		Criteria criteria = session.createCriteria(Customer.class);
		//���ò�ѯ�ľۺϺ���=>������
		criteria.setProjection(Projections.rowCount());
		Long c = (Long) criteria.uniqueResult();
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
