package cn.tao.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

import cn.tao.dao.LinkManDao;
import cn.tao.domain.LinkMan;
import cn.tao.Utils.HibernateUtils;

public class LinkManDaoImpl implements LinkManDao {

	public void save(LinkMan lm) {
		//1 获得session
		Session session = HibernateUtils.getCurrentSession();
		session.save(lm);
	}

	@Override
	public List<LinkMan> getAll(DetachedCriteria dc) {
		//1获得session
		Session session = HibernateUtils.openSession();
		//2将离线对象关联到session
		Criteria c = dc.getExecutableCriteria(session);
		//3执行查询并返回
		return c.list();
	}

}
