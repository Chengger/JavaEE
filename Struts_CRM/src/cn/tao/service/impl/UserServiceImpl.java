package cn.tao.service.impl;

import cn.tao.Utils.HibernateUtils;
import cn.tao.dao.UserDao;
import cn.tao.dao.impl.UserDaoImpl;
import cn.tao.domain.User;
import cn.tao.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao ud = new UserDaoImpl();

	@Override
	public User login(User user) {
		
		//������
		HibernateUtils.getCurrentSession().beginTransaction();
		//1.����Dao���ݵ�½���Ʋ�ѯUser����
		User existU = ud .getByUserCode(user.getUser_code());
		//�ύ����
		HibernateUtils.getCurrentSession().getTransaction().commit();
		
		if(existU==null){
			//��ò���=>�׳��쳣��ʾ�û���������
			throw new RuntimeException("�û���������!");
		}
		//2 �ȶ������Ƿ�һ��
		if(!existU.getUser_password().equals(user.getUser_password())){
			//��һ��=>�׳��쳣��ʾ�������
			throw new RuntimeException("�������!");
		}
		//3 �����ݿ��ѯ��User����
		return existU;
	}

}
