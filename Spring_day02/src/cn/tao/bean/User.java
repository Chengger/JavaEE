package cn.tao.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
//<bean name="user" class="cn.itcast.bean.User"  />
//@Component("user")
//	@Service("user") // service��
//	@Controller("user") // web��
	@Repository("user")// dao��
//ָ����������÷�Χ
@Scope(scopeName="singleton")
public class User {
	
	
	@Value("ton")
	private String name;
	@Value(value="18")
	private Integer age;
	
	
	//@Autowired //�Զ�װ��
		//����:���ƥ��������һ�µĶ���.���޷�ѡ�����ע����һ������.
	//@Qualifier("car2")//ʹ��@Qualifierע�����spring�����Զ�װ���ĸ����ƵĶ���
	@Resource(name="car")//�ֶ�ע��,ָ��ע���ĸ����ƵĶ���
	private Car car;
	
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
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
	@PostConstruct //�ڶ��󴴽������
	public void init(){
		System.out.println("���ǳ�ʼ������!");
	}
	@PreDestroy   //������֮ǰ����
	public void destory(){
		System.out.println("�������ٷ���!");
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", car=" + car + "]";
	}
	
}
