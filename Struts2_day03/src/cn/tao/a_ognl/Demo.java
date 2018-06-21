package cn.tao.a_ognl;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import cn.tao.bean.User;
import ognl.Ognl;
import ognl.OgnlContext;

//չʾOGNL�﷨
public class Demo {
	@Test
	//׼������
	public void fun1() throws Exception{
		//׼��ONGLContext
			//׼��Root
			User rootUser = new User("tom",18);
			//׼��Context
			Map<String,User> context = new HashMap<String,User>();
			context.put("user1", new User("jack",18));
			context.put("user2", new User("rose",22));
		OgnlContext oc = new OgnlContext();
		//��rootUser��Ϊroot����
		oc.setRoot(rootUser);
		//��context���Map��ΪContext����
		oc.setValues(context);
		//��дOGNL
		Ognl.getValue("", oc, oc.getRoot());
	}
	
	@Test
	//�����﷨��ʾ
	//ȡ��root�е�����ֵ
	public void fun2() throws Exception{
		//׼��ONGLContext
			//׼��Root
			User rootUser = new User("tom",18);
			//׼��Context
			Map<String,User> context = new HashMap<String,User>();
			context.put("user1", new User("jack",18));
			context.put("user2", new User("rose",22));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);
		//��дOGNL
		
		//ȡ��root��user�����name����
		String name = (String) Ognl.getValue("name", oc, oc.getRoot());
		Integer age = (Integer) Ognl.getValue("age", oc, oc.getRoot());
		System.out.println(name);
		System.out.println(age);
	}
	@Test
	//�����﷨��ʾ
	//ȡ��context�е�����ֵ
	public void fun3() throws Exception{
		//׼��ONGLContext
			//׼��Root
			User rootUser = new User("tom",18);
			//׼��Context
			Map<String,User> context = new HashMap<String,User>();
			context.put("user1", new User("jack",18));
			context.put("user2", new User("rose",22));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);
		//��дOGNL
		
		//ȡ��context�м�Ϊuser1�����name����
		String name = (String) Ognl.getValue("#user1.name", oc, oc.getRoot());
		String name2 = (String) Ognl.getValue("#user2.name", oc, oc.getRoot());
		Integer age = (Integer) Ognl.getValue("#user2.age", oc, oc.getRoot());
		System.out.println(name);
		System.out.println(name2);
		System.out.println(age);
	}
	
	@Test
	//�����﷨��ʾ
	//Ϊ���Ը�ֵ
	public void fun4() throws Exception{
		//׼��ONGLContext
			//׼��Root
			User rootUser = new User("tom",18);
			//׼��Context
			Map<String,User> context = new HashMap<String,User>();
			context.put("user1", new User("jack",18));
			context.put("user2", new User("rose",22));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);
		//��дOGNL
		
		//��root�е�user�����name���Ը�ֵ
		Ognl.getValue("name='jerry'", oc, oc.getRoot());
		String name = (String) Ognl.getValue("name", oc, oc.getRoot());
		
		String name2 = (String) Ognl.getValue("#user1.name='��ǿ��',#user1.name", oc, oc.getRoot());
		System.out.println(name);
		System.out.println(name2);
	}
	
	@Test
	//�����﷨��ʾ
	//���÷���
	public void fun5() throws Exception{
		//׼��ONGLContext
			//׼��Root
			User rootUser = new User("tom",18);
			//׼��Context
			Map<String,User> context = new HashMap<String,User>();
			context.put("user1", new User("jack",18));
			context.put("user2", new User("rose",22));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);
		//��дOGNL
		
		//����root��user�����setName����
		Ognl.getValue("setName('lilei')", oc, oc.getRoot());
		String name = (String) Ognl.getValue("getName()", oc, oc.getRoot());
		
		String name2 = (String) Ognl.getValue("#user1.setName('lucy'),#user1.getName()", oc, oc.getRoot());
		
		
		System.out.println(name);
		System.out.println(name2);
	}
	
	
	@Test
	//�����﷨��ʾ
	//���þ�̬����
	public void fun6() throws Exception{
		//׼��ONGLContext
			//׼��Root
			User rootUser = new User("tom",18);
			//׼��Context
			Map<String,User> context = new HashMap<String,User>();
			context.put("user1", new User("jack",18));
			context.put("user2", new User("rose",22));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);
		//��дOGNL
		
		String name = (String) Ognl.getValue("@cn.tao.a_ognl.HahaUtils@echo('hello ǿ��!')", oc, oc.getRoot());
		//Double pi = (Double) Ognl.getValue("@java.lang.Math@PI", oc, oc.getRoot());
		Double pi = (Double) Ognl.getValue("@@PI", oc, oc.getRoot());
		System.out.println(name);
		System.out.println(pi);
	}	
	
	@Test
	//�����﷨��ʾ
	//ognl��������-list|map
	public void fun7() throws Exception{
		//׼��ONGLContext
			//׼��Root
			User rootUser = new User("tom",18);
			//׼��Context
			Map<String,User> context = new HashMap<String,User>();
			context.put("user1", new User("jack",18));
			context.put("user2", new User("rose",22));
		OgnlContext oc = new OgnlContext();
		oc.setRoot(rootUser);
		oc.setValues(context);
		//��дOGNL
		
		//����list����
		Integer size = (Integer) Ognl.getValue("{'tom','jerry','jack','rose'}.size()", oc, oc.getRoot());
		String name = (String) Ognl.getValue("{'tom','jerry','jack','rose'}[0]", oc, oc.getRoot());
		String name2 = (String) Ognl.getValue("{'tom','jerry','jack','rose'}.get(1)", oc, oc.getRoot());
	
		/*System.out.println(size);
		System.out.println(name);
		System.out.println(name2);*/
		//����Map����
		Integer size2 = (Integer) Ognl.getValue("#{'name':'tom','age':18}.size()", oc, oc.getRoot());//#�ű�ʾ����map
		String name3  = (String) Ognl.getValue("#{'name':'tom','age':18}['name']", oc, oc.getRoot());
		Integer age  = (Integer) Ognl.getValue("#{'name':'tom','age':18}.get('age')", oc, oc.getRoot());
		System.out.println(size2);
		System.out.println(name3);
		System.out.println(age);
	}	

}
