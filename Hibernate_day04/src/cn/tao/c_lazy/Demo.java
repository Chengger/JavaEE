package cn.tao.c_lazy;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.tao.HibernateUtils.HibernateUtils;
import cn.tao.domain.Customer;

//������|�ӳټ���
public class Demo {
	
	@Test
	// get���� : ��������.ִ�з���ʱ��������sql����ѯ���
	public void fun1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//----------------------------------------------------
		
		Customer c = session.get(Customer.class, 2l);
		
		System.out.println(c);
		//----------------------------------------------------
		tx.commit();
		session.close();
		
	}
	
	@Test
	// load����(Ĭ��):����ִ��ʱ,�������κ�sql���.����һ������.ʹ�øö���ʱ,��ִ�в�ѯ.
	// �ӳټ���: �������û��ʹ��.�����ѯ.��ʹ��ʱ�Ž��в�ѯ.
	// �Ƿ��������ӳټ���: ����ͨ����classԪ��������lazy����������.
		//lazy:true  ����ʱ,����ѯ.ʹ��ʱ�Ų�ѯb
		//lazy:false ����ʱ������ѯ.
	public void fun2(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//----------------------------------------------------
		
		Customer c = session.load(Customer.class, 2l);
		System.out.println(c);
		//----------------------------------------------------
		tx.commit();
		session.close();
		
		
	}
	
}
