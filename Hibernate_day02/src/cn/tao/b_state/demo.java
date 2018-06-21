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
	//������������
	public void fun1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		Customer c = new Customer();//û��id,û����session����=>˲ʱ״̬
		c.setCust_name("��Ϊ");//˲ʱ״̬
		
		session.save(c);//�־û�״̬,��id,�й���
		
		tx.commit();
		session.close();//����|�й�״̬,��id,û�й���
	}
	
	@Test
	//����״̬�ص�
	//save����:��ʵ�������ɱ��棬���ɽ�˲ʱ״̬ת��Ϊ�־û�״̬
	//��������:ִ��save����ʱ��Ϊ�˽�����ת��Ϊ�־û�״̬
	//increment:ִ��save����,Ϊ������id,��ִ�в�ѯid���ֵ��sql���
	public void fun2(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		Customer c = new Customer();//û��id,û����session����=>˲ʱ״̬
		c.setCust_name("��Ϊ");//˲ʱ״̬
		
		session.save(c);//�־û�״̬,��id,�й���
		
		tx.commit();
		session.close();//����|�й�״̬,��id,û�й���
	}
	
	
	@Test
	//����״̬�ص�
	//�־û�״̬�ص�:�־û�״̬������κα仯�����Զ�ͬ�������ݿ���
	public void fun3(){
		//1���session
		Session session = HibernateUtils.openSession();
		//2��������
		Transaction tx = session.beginTransaction();
		//3ִ�в���
		Customer c = session.get(Customer.class, 1l);//�־û�״̬
		c.setCust_name("apple");
		//4�ύ���񣬹ر���Դ
		tx.commit();
		session.close();//����|�й�״̬,��id,û�й���
	}
}
