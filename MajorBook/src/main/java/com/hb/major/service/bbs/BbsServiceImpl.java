package com.hb.major.service.bbs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.hb.major.model.bbs.BbsDao;
import com.hb.major.model.entity.BbsVo;

@Service
public class BbsServiceImpl implements BbsService {
	@Autowired
	BbsDao bbsDao;
	
	@Override
	public void bbsListAll(Model model) {
		try {
			model.addAttribute("list", bbsDao.bbsSelectAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void bbsAddOne(BbsVo bean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bbsDetailOne(int sabun, Model model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bbsEditOne(int sabun, Model model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bbsUpdateOne(BbsVo bean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bbsDeleteOne(int sabun) {
		// TODO Auto-generated method stub
		
	}


}
