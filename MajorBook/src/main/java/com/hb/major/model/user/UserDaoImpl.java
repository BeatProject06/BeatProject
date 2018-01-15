package com.hb.major.model.user;

import org.apache.ibatis.session.SqlSession;

import com.hb.major.model.entity.UserVo;

public class UserDaoImpl implements UserDao {
	
	SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	@Override
	public void userInsertOne(UserVo bean) throws Exception {
		session.insert("com.hb.major.model.user.UserDao.userInsertOne", bean);
	}

}
