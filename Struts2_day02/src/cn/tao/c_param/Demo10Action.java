package cn.tao.c_param;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.media.sound.ModelChannelMixer;

import cn.tao.domain.User;

//struts2��λ�ò���-��ʽ2
public class Demo10Action extends ActionSupport implements ModelDriven<User> {
	//׼��user ��Ա����
	private User user =new User();

	public String execute() throws Exception { 
		
		System.out.println(user);
		
		return SUCCESS;
	}

	@Override
	public User getModel() {
		return user;
	}


	
}
