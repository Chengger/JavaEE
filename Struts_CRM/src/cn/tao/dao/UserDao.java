package cn.tao.dao;

import cn.tao.domain.User;

public interface UserDao {
	//���ݵ�½������User
		User getByUserCode(String user_code);
}
