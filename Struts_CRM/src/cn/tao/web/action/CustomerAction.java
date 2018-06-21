package cn.tao.web.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.tao.domain.Customer;
import cn.tao.service.CustomerService;
import cn.tao.service.impl.CustomerServiceImpl;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	private CustomerService cs = new CustomerServiceImpl();
	private Customer customer = new Customer();
	public String list() throws Exception {
		//1 ���ܲ���
		String cust_name = ServletActionContext.getRequest().getParameter("cust_name");
		//2 �������߲�ѯ����
		DetachedCriteria dc =DetachedCriteria.forClass(Customer.class);
		//3 �жϲ���ƴװ����
		if(StringUtils.isNotBlank(cust_name)){
			dc.add(Restrictions.like("cust_name", "%"+cust_name+"%"));
		}
		//4 ����Service�����߶��󴫵�
		List<Customer> list = cs.getAll(dc);
		//5 �����ص�list����request��.ת����list.jsp��ʾ
//		ServletActionContext.getRequest().setAttribute("list", list);
		// �ŵ�ActionContext
		ActionContext.getContext().put("list", list);
				
		return "list";
	}
	

	public String add() throws Exception {
		//1����service
		cs.save(customer);
		//2�ض����б�acttion
		return "toList";
	}

	@Override
	public Customer getModel() {
		return customer;
	}

	
	
}

