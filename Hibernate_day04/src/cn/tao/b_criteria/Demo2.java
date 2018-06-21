package cn.tao.b_criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import cn.tao.HibernateUtils.HibernateUtils;
import cn.tao.domain.Customer;

//ѧϰ����Criteria
public class Demo2 {
	
	@Test
	public void fun1(){
		//Service/web��
		DetachedCriteria dc  = DetachedCriteria.forClass(Customer.class);
		
		dc.add(Restrictions.idEq(3l));//ƴװ����(ȫ������ͨCriteriaһ��)
		
		//----------------------------------------------------
		Session session = HibernateUtils.openSession();
		Transaction tx = session.beginTransaction();
		//----------------------------------------------------
		Criteria c = dc.getExecutableCriteria(session);
		
		List list = c.list();
		
		System.out.println(list);
		//----------------------------------------------------
		tx.commit();
		session.close();
		
	}
	
}

