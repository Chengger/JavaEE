package cn.tao.c_param;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

//struts2��λ�ò���
//ÿ������Actionʱ���ᴴ���µ�Actionʵ������
public class Demo8Action extends ActionSupport  {
	
	public Demo8Action() {
		super();
		System.out.println("demo8Action��������!");
	}


	//׼���������������ͬ������
	private String name;
	//�Զ�����ת�� ֻ��ת��8��������������Լ���Ӧ��װ��
	private Integer age;
	//֧���ض������ַ���ת��ΪDate ,���� yyyy-MM-dd
	private Date   birthday;
	

	public String execute() throws Exception { 
		
		System.out.println("name����ֵ:"+name+",age����ֵ:"+age+",����:"+birthday);
		
		return SUCCESS;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	
}
