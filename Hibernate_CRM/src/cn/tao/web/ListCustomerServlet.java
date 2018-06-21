package cn.tao.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import cn.tao.domain.Customer;
import cn.tao.service.CustomerService;
import cn.tao.service.impl.CustomerServiceImpl;

/**
 * Servlet implementation class ListCustomerServlet
 */
public class ListCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService cs = new CustomerServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1��ò�ѯ����
		String cust_name = request.getParameter("cust_name");
		
		//2�жϲ�ѯ�����Ƿ�Ϊ��
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		if (cust_name != null && !"".equals(cust_name)) {
			dc.add(Restrictions.like("cust_name", "%"+cust_name+"%"));
		}
		
		//1����service��ѯ���пͻ�
		List<Customer> list = cs.getAll(dc);
		//2���ͻ��б����request��
		request.setAttribute("list", list);
		//3ת����list��jsp��ʾ
		request.getRequestDispatcher("/jsp/customer/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
