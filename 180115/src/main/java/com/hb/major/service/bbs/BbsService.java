package com.hb.major.service.bbs;

import org.springframework.ui.Model;

import com.hb.major.model.entity.BbsVo;

public interface BbsService {
	void bbsListAll(Model model);
	void bbsAddOne(BbsVo bean);
	void bbsDetailOne(int no, Model model);
	void bbsEditOne(int sabun, Model model);
	void bbsUpdateOne(BbsVo bean);
	void bbsDeleteOne(int sabun);

}
