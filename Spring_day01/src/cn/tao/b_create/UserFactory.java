package cn.tao.b_create;

import cn.tao.bean.User;

public class UserFactory {

	public static User createUser(){
		
		System.out.println("��̬��������user");
		
		return new User();
		
	}
	
	public  User createUser2(){
		
		System.out.println("ʵ����������user");
		
		return new User();
		
	}
	
}
