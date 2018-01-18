package com.hb.major.model.bbs;

import java.util.List;
import java.util.Map;

import com.hb.major.model.entity.BbsVo;

public interface BbsDao {
	List<BbsVo> bbsSelectAll() throws Exception;
	void bbsInsertOne(BbsVo bean) throws Exception;
	BbsVo bbsSelectOne(int no) throws Exception;
	int bbsUpdateOne(BbsVo bean) throws Exception;
	int bbsDeleteOne(int no) throws Exception;
	
}
