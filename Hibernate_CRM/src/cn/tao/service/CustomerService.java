package cn.tao.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.tao.domain.Customer;

public interface CustomerService {

	void save(Customer c);
	//������пͻ���Ϣ
	List<Customer> getAll();
	//����������ѯ�û�
	List<Customer> getAll(DetachedCriteria dc);
}