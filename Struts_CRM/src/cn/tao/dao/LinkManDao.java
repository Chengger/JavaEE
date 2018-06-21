package cn.tao.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.tao.domain.LinkMan;

public interface LinkManDao {
	//保存联系人
	void save(LinkMan lm);

	 List<LinkMan> getAll(DetachedCriteria dc) ;
		

	

}
