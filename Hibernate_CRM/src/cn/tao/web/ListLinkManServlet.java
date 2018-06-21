package cn.tao.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import cn.tao.domain.LinkMan;
import cn.tao.service.LinkManService;
import cn.tao.service.impl.LinkManServiceImpl;

/**
 * Servlet implementation class ListLinkManServlet
 */
public class ListLinkManServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LinkManService ls = new LinkManServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListLinkManServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1获得查询条件
				String lkm_name = request.getParameter("lkm_name");
				
				//2判断查询条件是否不为空
				DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
				if (lkm_name != null && !"".equals(lkm_name)) {
					dc.add(Restrictions.like("lkm_name", "%"+lkm_name+"%"));
				}
				
				
				//1调用service查询所有客户
				List<LinkMan> list = ls.getAll(dc);
				//2将客户列表放入request域
				request.setAttribute("list", list);
				//3转发到list，jsp显示
				request.getRequestDispatcher("/jsp/linkman/list.jsp").forward(request, response);
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
