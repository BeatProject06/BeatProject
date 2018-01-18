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
		try {
			bbsDao.bbsInsertOne(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void bbsDetailOne(int no, Model model) {
		try {
			bbsDao.bbsSelectOne(no);
			model.addAttribute("bean", bbsDao.bbsSelectOne(no));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void bbsUpdateOne(BbsVo bean) {
		try {
			bbsDao.bbsUpdateOne(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void bbsDeleteOne(int no) {
		try {
			bbsDao.bbsDeleteOne(no);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
