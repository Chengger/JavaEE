package cn.tao.b_api;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
//�����action�л��ԭ��ServletAPI
public class Demo5Action extends ActionSupport {

	public String execute() throws Exception {
		//request��=> map (struts2�����Ƽ�ʹ��ԭ��request��)
		//���Ƽ�
		Map<String, Object> requestScope = (Map<String, Object>) ActionContext.getContext().get("request");
		//�Ƽ�
		ActionContext.getContext().put("name", "requestTom");
		//session�� => map
		Map<String, Object> sessionScope = ActionContext.getContext().getSession();
		sessionScope.put("name", "sessionTom");
		//application��=>map
		Map<String, Object> applicationScope = ActionContext.getContext().getApplication();
		applicationScope.put("name", "applicationTom");
		
		return SUCCESS;
	}

	
}
