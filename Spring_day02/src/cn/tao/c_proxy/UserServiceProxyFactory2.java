package cn.tao.c_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import cn.tao.service.UserService;
import cn.tao.service.UserServiceImpl;

//�۹����=>cglib����
public class UserServiceProxyFactory2 implements MethodInterceptor {
	

	public UserService getUserServiceProxy(){
		
		Enhancer en = new Enhancer();//���������ɴ������
		
		en.setSuperclass(UserServiceImpl.class);//���ö�˭���д���
		
		en.setCallback(this);//����Ҫ��ʲô
		
		UserService us = (UserService) en.create();//�����������
		
		return us;
	}

	@Override
	public Object intercept(Object prxoyobj, Method method, Object[] arg, MethodProxy methodProxy) throws Throwable {
		//������
		System.out.println("������!");
		//����ԭ�з���
		Object returnValue = methodProxy.invokeSuper(prxoyobj, arg);
		//�ύ����
		System.out.println("�ύ����!");
		
		return returnValue;
	}


}
