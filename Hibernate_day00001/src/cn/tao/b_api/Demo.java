package cn.tao.b_api;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class Demo {


	@Test
	public void fun1() {
	   
	 //1 ����,���ÿղι���
	 		Configuration conf = new Configuration();
	 		//2 ��ȡָ���������ļ� => �ղμ��ط���,����src�µ�hibernate.cfg.xml�ļ�
	 		conf.configure();
	 		//3 ��ȡָ��ormԪ����(��չ),������������Ѿ�����ӳ������.����Ҫ�ֶ�����
	 		//conf.addResource(resourceName);
	 		//conf.addClass(persistentClass);
	 		
	 		//4 ����������Ϣ,���� SessionFactory����
	 		SessionFactory sf = conf.buildSessionFactory();
    }


}
