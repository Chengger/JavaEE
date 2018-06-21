package cn.tao.d_lazy_fetch;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.tao.HibernateUtils.HibernateUtils;
import cn.tao.domain.Customer;
import cn.tao.domain.LinkMan;

//�������� �ӳټ��� & ץȡ����
public class Demo2 {
	
	@Test
	//fetch:select	�����ѯ
	//lazy:proxy  
		//customer-true ������
	public void fun1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//----------------------------------------------------
		
		LinkMan lm = session.get(LinkMan.class, 3l);
		
		Customer customer = lm.getCustomer();
		
		System.out.println(customer);
		
		//----------------------------------------------------
		tx.commit();
		session.close();
		
	}
	@Test
	//fetch:join	���
	//lazy: ʧЧ  
	public void fun3(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//----------------------------------------------------
		
		LinkMan lm = session.get(LinkMan.class, 3l);
		
		Customer customer = lm.getCustomer();
		
		System.out.println(customer);
		
		//----------------------------------------------------
		tx.commit();
		session.close();
		
	}
	@Test
	//fetch:select	�����ѯ
	//lazy:proxy  
		//customer-false ��������
	public void fun2(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//----------------------------------------------------
		
		LinkMan lm = session.get(LinkMan.class, 3l);
		
		Customer customer = lm.getCustomer();
		
		System.out.println(customer);
		
		//----------------------------------------------------
		tx.commit();
		session.close();
		
	}
}
