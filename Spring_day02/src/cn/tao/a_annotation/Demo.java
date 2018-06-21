package cn.tao.a_annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.tao.bean.User;


public class Demo {
	@Test
	public void fun1() {
		//1.创建容器对象
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("cn/tao/bean/applicationContext.xml");
		//2.向容器要user对象
		User u1 = (User) ac.getBean("user");
		User u2 = (User) ac.getBean("user");
		//3.打印user对象
		System.out.println(u1==u2);
		System.out.println(u1);
		ac.close();
	}
	
	
	
}
