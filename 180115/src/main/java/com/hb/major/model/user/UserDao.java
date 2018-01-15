package com.hb.major.model.user;

import com.hb.major.model.entity.UserVo;

public interface UserDao {
//	List<UserVo> selectAll() throws Exception;
//	UserVo UserSelectOne(int sabun) throws Exception;
	void userInsertOne(UserVo bean) throws Exception;
//	int UserUpdateOne(UserVo bean) throws Exception;
//	int UserDeleteOne(int sabun) throws Exception;
}
