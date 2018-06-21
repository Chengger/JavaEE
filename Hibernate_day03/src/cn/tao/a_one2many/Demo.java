package cn.tao.a_one2many;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.tao.domain.Customer;
import cn.tao.domain.LinkMan;
import cn.tao.HibernateUtils.HibernateUtils;;

//һ�Զ�|���һ��ϵ����
public class Demo {
	@Test
	//����ͻ� �Լ��ͻ� �µ���ϵ��
	public void fun1(){
		//1 ���session
		Session session = HibernateUtils.openSession();
		//2 ��������
		Transaction tx = session.beginTransaction();
		//-------------------------------------------------
		//3����
		Customer c = new Customer();
		c.setCust_name("���ǲ���");
		
		LinkMan lm1 = new LinkMan();
		lm1.setLkm_name("�����");
		
		LinkMan lm2 = new LinkMan();
		lm2.setLkm_name("���ö�");
		
		//���һ�Զ�,�ͻ����ж����ϵ��
		c.getLinkMens().add(lm1);
		c.getLinkMens().add(lm2);
		
		//�����һ,��ϵ�������ĸ��ͻ�
		lm1.setCustomer(c);
		lm2.setCustomer(c);
		
		
		session.save(c);
//		session.save(lm1);
//		session.save(lm2);
		
		//-------------------------------------------------
		//4�ύ����
		tx.commit();
		//5�ر���Դ
		session.close();
	}
	
	@Test
	//Ϊ�ͻ�������ϵ��
	public void fun2(){
		//1 ���session
		Session session = HibernateUtils.openSession();
		//2 ��������
		Transaction tx = session.beginTransaction();
		//-------------------------------------------------
		//3����
		//1> ���Ҫ�����Ŀͻ�����
		Customer c = session.get(Customer.class,1l);
		//2> ������ϵ��
		LinkMan lm1 = new LinkMan();
		lm1.setLkm_name("��ǿ��");
		//3> ����ϵ����ӵ��ͻ�,���ͻ����õ���ϵ����
		c.getLinkMens().add(lm1);
		lm1.setCustomer(c);
		//4> ִ�б���
		session.save(lm1);
		//-------------------------------------------------
		//4�ύ����
		tx.commit();
		//5�ر���Դ
		session.close();
	}
	
	@Test
	//Ϊ�ͻ�ɾ����ϵ��
	public void fun3(){
		//1 ���session
		Session session = HibernateUtils.openSession();
		//2 ��������
		Transaction tx = session.beginTransaction();
		//-------------------------------------------------
		//3����
		//1> ���Ҫ�����Ŀͻ�����
		Customer c = session.get(Customer.class,1l);
		//2> ���Ҫ�Ƴ�����ϵ��
		LinkMan lm = session.get(LinkMan.class, 3l);
		//3> ����ϵ�˴ӿͻ��������Ƴ�
		c.getLinkMens().remove(lm);
		lm.setCustomer(null);
		//-------------------------------------------------
		//4�ύ����
		tx.commit();
		//5�ر���Դ
		session.close();
	}
		
}
