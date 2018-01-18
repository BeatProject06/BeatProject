package com.hb.major.model.comment;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hb.major.model.entity.CommentVo;

@Repository
public class CommentDaoImpl implements CommentDao {
	
	SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
	}

	@Override
	public List<CommentVo> getCommentList(int postnum) throws Exception {
		return session.selectList("com.hb.major.model.comment.CommentDao.getCommentList", postnum);
		
	}

	@Override
	public void commentInsertOne(CommentVo cmtbean) throws Exception {
		System.out.println("ÄÚ¸àÆ® ´Ù¿Àµé¾î¿È");
		session.insert("com.hb.major.model.comment.CommentDao.commentInsertOne", cmtbean);
		
	}
	

}
