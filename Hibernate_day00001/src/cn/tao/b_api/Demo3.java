package cn.tao.b_api;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.tao.domain.Customer;

//ѧϰSession����
//session������: ���hibernate��������ݿ�֮�������(�Ự).session������
//				JDBC�����connection����. ��������ɶ����ݿ������ݵ���ɾ�Ĳ����.
//				session��hibernate�������ݿ�ĺ��Ķ���
public class Demo3 {

	@Test
	//�������
	public void fun1(){
		//1 ����,���ÿղι���
		Configuration conf = new Configuration().configure();
		//2 ����������Ϣ,���� SessionFactory����
		SessionFactory sf = conf.buildSessionFactory();
		//3 ���session
		Session session = sf.openSession();
		//4 session��ò��������Transaction����
		//��ò��������tx����
		//Transaction tx = session.getTransaction();
		//�������񲢻�ò��������tx����(����ʹ��)
		Transaction tx2 = session.beginTransaction();
		//----------------------------------------------
		
		//----------------------------------------------
		tx2.commit();//�ύ����
		tx2.rollback();//�ع�����
		session.close();//�ͷ���Դ
		sf.close();//�ͷ���Դ
	}
	
	@Test
	//session������
	public void fun2(){
		//1 ����,���ÿղι���
		Configuration conf = new Configuration().configure();
		//2 ����������Ϣ,���� SessionFactory����
		SessionFactory sf = conf.buildSessionFactory();
		//3 ���session
		Session session = sf.openSession();
		//4 session��ò��������Transaction����
		//��ò��������tx����
		//Transaction tx = session.getTransaction();
		//�������񲢻�ò��������tx����(����ʹ��)
		Transaction tx2 = session.beginTransaction();
		//----------------------------------------------
		Customer c = new Customer();
		c.setCust_name("���ǲ���");
		
		session.save(c);
		//----------------------------------------------
		tx2.commit();//�ύ����
		session.close();//�ͷ���Դ
		sf.close();//�ͷ���Դ
	}
	@Test
	//session�Ĳ�ѯ
	//��ѯidΪ1��customer����
	public void fun3(){
		//1 ����,���ÿղι���
		Configuration conf = new Configuration().configure();
		//2 ����������Ϣ,���� SessionFactory����
		SessionFactory sf = conf.buildSessionFactory();
		//3 ���session
		Session session = sf.openSession();
		//4 session��ò��������Transaction����
		//��ò��������tx����
		//Transaction tx = session.getTransaction();
		//�������񲢻�ò��������tx����(����ʹ��)
		Transaction tx2 = session.beginTransaction();
		//----------------------------------------------
		
		Customer customer = session.get(Customer.class, 2l);
		
		System.out.println(customer);
		//----------------------------------------------
		tx2.commit();//�ύ����
		session.close();//�ͷ���Դ
		sf.close();//�ͷ���Դ
	}
	@Test
	//session���޸�
	//�޸�idΪ1��customer�����name����Ϊ�������Ա
	public void fun4(){
		//1 ����,���ÿղι���
		Configuration conf = new Configuration().configure();
		//2 ����������Ϣ,���� SessionFactory����
		SessionFactory sf = conf.buildSessionFactory();
		//3 ���session
		Session session = sf.openSession();
		//4 session��ò��������Transaction����
		//��ò��������tx����
		//Transaction tx = session.getTransaction();
		//�������񲢻�ò��������tx����(����ʹ��)
		Transaction tx2 = session.beginTransaction();
		//----------------------------------------------
		//1 ���Ҫ�޸ĵĶ���
		Customer c = session.get(Customer.class, 2l);
		//2 �޸�
		c.setCust_name("�������Ա");
		//3 ִ��update
		session.update(c);
		//----------------------------------------------
		tx2.commit();//�ύ����
		session.close();//�ͷ���Դ
		sf.close();//�ͷ���Դ
	}
	@Test
	//session��ɾ��
	//ɾ��idΪ1��customer����
	public void fun5(){
		//1 ����,���ÿղι���
		Configuration conf = new Configuration().configure();
		//2 ����������Ϣ,���� SessionFactory����
		SessionFactory sf = conf.buildSessionFactory();
		//3 ���session
		Session session = sf.openSession();
		//4 session��ò��������Transaction����
		//��ò��������tx����
		Transaction tx = session.getTransaction();
		tx.begin();
		//�������񲢻�ò��������tx����(����ʹ��)
		Transaction tx2 = session.beginTransaction();
		//----------------------------------------------
		//1 ���Ҫ�޸ĵĶ���
		Customer c = session.get(Customer.class, 1l);
		//2 ����deleteɾ������
		session.delete(c);
		//----------------------------------------------
		tx2.commit();//�ύ����
		session.close();//�ͷ���Դ
		sf.close();//�ͷ���Դ
	}
}
