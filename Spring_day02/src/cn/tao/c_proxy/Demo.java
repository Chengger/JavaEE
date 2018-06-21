package cn.tao.c_proxy;

import org.junit.Test;

import cn.tao.service.UserService;
import cn.tao.service.UserServiceImpl;

public class Demo {
	
	@Test
	//��̬����
	public void fun1(){
		UserService us = new UserServiceImpl();
		
		UserServiceProxyFactory factory = new UserServiceProxyFactory(us);
		
		UserService usProxy = factory.getUserServiceProxy();
		
		usProxy.save();
		

		//��������뱻�������ʵ������ͬ�Ľӿ�
		//������� �� ���������û�м̳й�ϵ
		System.out.println(usProxy instanceof UserServiceImpl );//false
	}
	
	@Test
	public void fun2(){
		
		UserServiceProxyFactory2 factory = new UserServiceProxyFactory2();
		
		UserService usProxy = factory.getUserServiceProxy();
		
		usProxy.save();

		//�жϴ�������Ƿ����ڱ������������
		//�������̳��˱��������=>true
		System.out.println(usProxy instanceof UserServiceImpl );//true
	}
}
