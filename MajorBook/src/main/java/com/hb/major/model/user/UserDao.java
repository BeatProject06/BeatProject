package com.hb.major.model.user;

import com.hb.major.model.entity.UserVo;

public interface UserDao {
//	List<UserVo> selectAll() throws Exception;
//	UserVo userSelectOne(int no) throws Exception;
	void userInsertOne(UserVo bean) throws Exception;
//	int userUpdateOne(UserVo bean) throws Exception;
	int userDeleteOne(String no) throws Exception;
}
