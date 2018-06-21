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
		//1��ò�ѯ����
				String lkm_name = request.getParameter("lkm_name");
				
				//2�жϲ�ѯ�����Ƿ�Ϊ��
				DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
				if (lkm_name != null && !"".equals(lkm_name)) {
					dc.add(Restrictions.like("lkm_name", "%"+lkm_name+"%"));
				}
				
				
				//1����service��ѯ���пͻ�
				List<LinkMan> list = ls.getAll(dc);
				//2���ͻ��б����request��
				request.setAttribute("list", list);
				//3ת����list��jsp��ʾ
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
