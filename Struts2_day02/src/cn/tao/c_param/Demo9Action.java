package cn.tao.c_param;

import com.opensymphony.xwork2.ActionSupport;

import cn.tao.domain.User;


//struts2��λ�ò���-��ʽ2
public class Demo9Action extends ActionSupport  {
	//׼��user����
	private User user;

	public String execute() throws Exception { 
		
		System.out.println(user);
		
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}