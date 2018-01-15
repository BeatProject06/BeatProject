package com.hb.major.service.user;

import org.springframework.beans.factory.annotation.Autowired;

import com.hb.major.model.entity.UserVo;
import com.hb.major.model.user.UserDao;

public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;
	
	@Override
	public void UserAddOne(UserVo bean) {
		try {
			userDao.userInsertOne(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
