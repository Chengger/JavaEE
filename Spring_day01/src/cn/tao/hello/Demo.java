package cn.tao.hello;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tao.bean.User;
public class Demo {
	@Test
	public void fun1() {
		//1.������������
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2.������Ҫuser����
		User u = (User) ac.getBean("user");
		//3.��ӡuser����
		System.out.println(u);
		
	}
	
	
}
