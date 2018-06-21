package cn.tao.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.tao.domain.Customer;

public interface CustomerDao {

	void save(Customer c);
	//查询所有用户
	List<Customer> getAll();
	Customer getById(Long cust_id);
	List<Customer> getAll(DetachedCriteria dc);

}
