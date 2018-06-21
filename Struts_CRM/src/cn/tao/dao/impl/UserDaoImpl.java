package cn.tao.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;

import cn.tao.Utils.HibernateUtils;
import cn.tao.dao.UserDao;
import cn.tao.domain.User;

public class UserDaoImpl implements UserDao {
	@Override
	public User getByUserCode(String user_code) {
		//HQL��ѯ
		//1.���Session
		Session session = HibernateUtils.getCurrentSession();
		//2 ��дHQL
		String hql = "from User where user_code = ? ";
		//3 ������ѯ����
		Query query = session.createQuery(hql);
		//4 ���ò���
		query.setParameter(0, user_code);
		//5 ִ�в�ѯ
		User u = (User) query.uniqueResult();
		return u;
	}
}
