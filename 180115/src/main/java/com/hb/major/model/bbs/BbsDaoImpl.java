package com.hb.major.model.bbs;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hb.major.model.entity.BbsVo;

@Repository
public class BbsDaoImpl implements BbsDao {
	SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	@Override
	public List<BbsVo> bbsSelectAll() throws Exception {
		return session.selectList("com.hb.major.model.bbs.BbsDao.bbsSelectAll");
	}

	@Override
	public void bbsInsertOne(BbsVo bean) throws Exception {
		// TODO Auto-generated method stub
		session.selectOne("com.hb.major.model.bbs.BbsDao.bbs.bbsSelectOne");
	}

	@Override
	public BbsVo bbsSelectOne(int no) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int bbsUpdateOne(BbsVo bean) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int bbsDeleteOne(int no) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
