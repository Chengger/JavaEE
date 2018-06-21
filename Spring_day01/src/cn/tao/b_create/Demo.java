package cn.tao.b_create;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tao.bean.User;
public class Demo {
	@Test
	//������ʽ1
	public void fun1() {
		//1.������������
		ApplicationContext ac = new ClassPathXmlApplicationContext("cn/tao/b_create/applicationContext.xml");
		//2.������Ҫuser����
		User u = (User) ac.getBean("user");
		//3.��ӡuser����
		System.out.println(u);
		
	}
	//������ʽ2:��̬����
			@Test
			public void fun2(){
				//1 ������������
				ApplicationContext ac = new ClassPathXmlApplicationContext("cn/tao/b_create/applicationContext.xml");
				//2 ������"Ҫ"user����
				User u = (User) ac.getBean("user2");
				//3 ��ӡuser����
				System.out.println(u);
			}
			//������ʽ3:ʵ������
			@Test
			public void fun3(){
				//1 ������������
				ApplicationContext ac = new ClassPathXmlApplicationContext("cn/tao/b_create/applicationContext.xml");
				//2 ������"Ҫ"user����
				User u = (User) ac.getBean("user3");
				//3 ��ӡuser����
				System.out.println(u);
			}
					
			@Test
			//scope:singleton ����
			//scope:prototype ����
			public void fun4(){
				//1 ������������
				ApplicationContext ac = new ClassPathXmlApplicationContext("cn/tao/b_create/applicationContext.xml");
				//2 ������"Ҫ"user����
				User u = (User) ac.getBean("user");
				User u2 = (User) ac.getBean("user");
				User u3 = (User) ac.getBean("user");
				User u4 = (User) ac.getBean("user");
						
				System.out.println(u2==u4);//����:true
												   //����:false
				//3 ��ӡuser����
				System.out.println(u);
			}
			
			@Test
			//�����������ڷ���
			public void fun5(){
				//1 ������������
				ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("cn/tao/b_create/applicationContext.xml");
				//2 ������"Ҫ"user����
				User u = (User) ac.getBean("user");
				//3 ��ӡuser����
				System.out.println(u);
				//�ر�����,�������ٷ���
				ac.close();
			}
	
	
}
