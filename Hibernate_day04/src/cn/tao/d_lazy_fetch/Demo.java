package cn.tao.d_lazy_fetch;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.tao.HibernateUtils.HibernateUtils;
import cn.tao.domain.Customer;
import cn.tao.domain.LinkMan;

//�������� �ӳټ��� & ץȡ����
public class Demo {
	
	//���ϼ���Ĺ���
	//fetch:select �����ѯ
	//lazy:true ʹ��ʱ�ż��ؼ�������.
	@Test
	public void fun1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//----------------------------------------------------
		
		Customer c = session.get(Customer.class, 2l);
		
		Set<LinkMan> linkMens = c.getLinkMens();//��������
		
		System.out.println(linkMens);
		
		//----------------------------------------------------
		tx.commit();
		session.close();
		
	}
	
	//���ϼ���Ĺ���
		//fetch:select �����ѯ
		//lazy:false �������ؼ�������
		@Test
		public void fun2(){
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			//----------------------------------------------------
			
			Customer c = session.get(Customer.class, 2l);
			
			Set<LinkMan> linkMens = c.getLinkMens();//��������
			
			System.out.println(linkMens);
			
			//----------------------------------------------------
			tx.commit();
			session.close();
			
		}
		//���ϼ���Ĺ���
		//fetch:select �����ѯ
		//lazy:extra ��������.��������Ч������һ��. ���ֻ��ü��ϵ�size.ֻ��ѯ���ϵ�size(count���)
		@Test
		public void fun3(){
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			//----------------------------------------------------
			
			Customer c = session.get(Customer.class, 2l);
			
			Set<LinkMan> linkMens = c.getLinkMens();//��������
			
			System.out.println(linkMens.size());
			
			System.out.println(linkMens);
			
			//----------------------------------------------------
			tx.commit();
			session.close();
			
		}
		//���ϼ���Ĺ���
		//fetch:join	����ѯ
		//lazy:true|false|extra ʧЧ.��������.
		@Test
		public void fun4(){
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			//----------------------------------------------------
			
			Customer c = session.get(Customer.class, 2l);
			
			Set<LinkMan> linkMens = c.getLinkMens();//��������
			
			System.out.println(linkMens.size());
			
			System.out.println(linkMens);
			
			//----------------------------------------------------
			tx.commit();
			session.close();
			
		}
		
		@Test
		//fetch: subselect �Ӳ�ѯ
		//lazy: true ������
		public void fun5(){
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			//----------------------------------------------------
				
			String  hql = "from Customer";
			
			Query query = session.createQuery(hql);
			
			List<Customer> list = query.list();
			
			for(Customer c:list){
				System.out.println(c);
				System.out.println(c.getLinkMens().size());
				System.out.println(c.getLinkMens());
			}
			
			//----------------------------------------------------
			tx.commit();
			session.close();
			
		}
		@Test
		//fetch: subselect �Ӳ�ѯ
		//lazy: false ��������
		public void fun6(){
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			//----------------------------------------------------
				
			String  hql = "from Customer";
			
			Query query = session.createQuery(hql);
			
			List<Customer> list = query.list();
			
			for(Customer c:list){
				System.out.println(c);
				System.out.println(c.getLinkMens().size());
				System.out.println(c.getLinkMens());
			}
			
			//----------------------------------------------------
			tx.commit();
			session.close();
			
		}
		@Test
		//fetch: subselect �Ӳ�ѯ
		//lazy: extra ��������
		public void fun7(){
			Session session = HibernateUtils.openSession();
			Transaction tx = session.beginTransaction();
			//----------------------------------------------------
				
			String  hql = "from Customer";
			
			Query query = session.createQuery(hql);
			
			List<Customer> list = query.list();
			
			for(Customer c:list){
				System.out.println(c);
				System.out.println(c.getLinkMens().size());
				System.out.println(c.getLinkMens());
			}
			
			//----------------------------------------------------
			tx.commit();
			session.close();
			
		}
	
}
