package cn.tao.dao;

import cn.tao.domain.User;

public interface UserDao {
	//根据登陆名返回User
		User getByUserCode(String user_code);
}
