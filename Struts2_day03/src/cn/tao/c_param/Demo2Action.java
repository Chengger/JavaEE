package cn.tao.c_param;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.util.ValueStack;

import cn.tao.bean.User;

public class Demo2Action extends ActionSupport implements ModelDriven<User> {
	
	private User u = new User();
	
	@Override
	public String execute() throws Exception {
		
		
		
		System.out.println(u);
		
		
		return SUCCESS;
	}

	/*@Override
	public void prepare() throws Exception {
				//ѹ��ջ��
				//1���ֵջ
				ValueStack vs = ActionContext.getContext().getValueStack();
				//2��uѹ��ջ��
				vs.push(u);
	}*/

	@Override
	public User getModel() {
		return u;
	}

	
}