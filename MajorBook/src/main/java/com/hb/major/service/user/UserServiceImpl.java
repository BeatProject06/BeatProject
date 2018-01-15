package com.hb.major.service.user;

import org.springframework.beans.factory.annotation.Autowired;

import com.hb.major.model.entity.UserVo;
import com.hb.major.model.user.UserDao;
import com.hb.major.model.user.UserDaoImpl;

public class UserServiceImpl implements UserService {
	@Autowired
	UserDaoImpl userDao;
	
	@Override
	public void userAddOne(UserVo bean) {
		try {
			userDao.userInsertOne(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
