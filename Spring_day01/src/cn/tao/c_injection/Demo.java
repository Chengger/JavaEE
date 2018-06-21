package cn.tao.c_injection;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tao.bean.User;
public class Demo {
	@Test
	public void fun1() {
		//1.������������
		ApplicationContext ac = new ClassPathXmlApplicationContext("cn/tao/c_injection/applicationContext.xml");
		//2.������Ҫuser����
		User u = (User) ac.getBean("user");
		//3.��ӡuser����
		System.out.println(u);
		
	}
	@Test
	public void fun2() {
		//1.������������
		ApplicationContext ac = new ClassPathXmlApplicationContext("cn/tao/c_injection/applicationContext.xml");
		//2.������Ҫuser����
		User u = (User) ac.getBean("user2");
		//3.��ӡuser����
		System.out.println(u);
		
	}
	@Test
	public void fun3(){
		
		//1 ������������
		ApplicationContext ac = new ClassPathXmlApplicationContext("cn/tao/c_injection/applicationContext.xml");
		//2 ������"Ҫ"user����
		User u = (User) ac.getBean("user3");
		//3 ��ӡuser����
		System.out.println(u);
		
	}
	
	@Test
	public void fun4(){
		
		//1 ������������
		ApplicationContext ac = new ClassPathXmlApplicationContext("cn/tao/c_injection/applicationContext.xml");
		//2 ������"Ҫ"user����
		User u = (User) ac.getBean("user4");
		//3 ��ӡuser����
		System.out.println(u);
		
	}
	
	@Test
	public void fun5(){
		
		//1 ������������
		ApplicationContext ac = new ClassPathXmlApplicationContext("cn/tao/c_injection/applicationContext.xml");
		//2 ������"Ҫ"user����
		CollectionBean cb = (CollectionBean) ac.getBean("cb");
		//3 ��ӡuser����
		System.out.println(cb);
		
	}
	
}
