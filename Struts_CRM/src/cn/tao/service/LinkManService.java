package cn.tao.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.tao.domain.LinkMan;

public interface LinkManService {
	//������ϵ��
	void save(LinkMan lm);

	List<LinkMan> getAll(DetachedCriteria dc);

}
