package cn.tao.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.tao.domain.Customer;

public interface CustomerService {

	void save(Customer c);
	//获得所有客户信息
	List<Customer> getAll();
	//根据条件查询用户
	List<Customer> getAll(DetachedCriteria dc);
}