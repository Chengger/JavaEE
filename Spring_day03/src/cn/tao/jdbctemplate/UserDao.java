package cn.tao.jdbctemplate;

import java.util.List;

import cn.tao.bean.User;

public interface UserDao {


	//��
	void save(User u);
	//ɾ
	void delete(Integer id);
	//��
	void update(User u);
	//��
	User getById(Integer id);
	//��
	int getTotalCount();
	//��
	List<User> getAll();
}
