package cn.tao.a_hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.tao.HibernateUtils.HibernateUtils;
import cn.tao.domain.Customer;

//ѧϰHQL�﷨(������) - ����ѯ�﷨
public class Demo2 {
	//�ع�-ԭ��SQL
	// ��������-�ѿ�����(����)
//		select * from A,B 
	// ������
//		|-��ʽ������
//			select * from A,B  where b.aid = a.id
//		|-��ʽ������
//			select * from A inner join B on b.aid = a.id
	// ������
//		|- ����
//			select * from A left [outer] join B on b.aid = a.id
//		|- ����
//			select * from A right [outer] join B on b.aid = a.id
//---------------------------------------------------------------------
//HQL�Ķ���ѯ
		//������(����)
		//������
//			|-����(����)
//			|-����(����)
	
	@Test
	//HQL ������ => �����ӵ����˶���ֱ𷵻�.�ŵ�������.
	public void fun1(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//----------------------------------------------------
		String hql = " from Customer c inner join c.linkMens ";
		
		Query query = session.createQuery(hql);
		
		List<Object[]> list = query.list();
		
		for(Object[] arr : list){
			System.out.println(Arrays.toString(arr));
		}
		//----------------------------------------------------
		tx.commit();
		session.close();
		
	}
	
	@Test
	//HQL ���������� => �����ǽ��з�װ.����ֵ����һ������
	public void fun2(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//----------------------------------------------------
		String hql = " from Customer c inner join fetch c.linkMens ";
		
		Query query = session.createQuery(hql);
		
		List<Customer> list = query.list();
		
		System.out.println(list);
		//----------------------------------------------------
		tx.commit();
		session.close();
		
	}
	
	@Test
	//HQL �������� => �����ӵ����˶���ֱ𷵻�.�ŵ�������.
	public void fun3(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//----------------------------------------------------
		String hql = " from Customer c left join c.linkMens ";
		
		Query query = session.createQuery(hql);
		
		List<Object[]> list = query.list();
		
		for(Object[] arr : list){
			System.out.println(Arrays.toString(arr));
		}
		//----------------------------------------------------
		tx.commit();
		session.close();
		
	}
	@Test
	//HQL �������� => �����ӵ����˶���ֱ𷵻�.�ŵ�������.
	public void fun4(){
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//----------------------------------------------------
		String hql = " from Customer c right join c.linkMens ";
		
		Query query = session.createQuery(hql);
		
		List<Object[]> list = query.list();
		
		for(Object[] arr : list){
			System.out.println(Arrays.toString(arr));
		}
		//----------------------------------------------------
		tx.commit();
		session.close();
		
	}
	
}
