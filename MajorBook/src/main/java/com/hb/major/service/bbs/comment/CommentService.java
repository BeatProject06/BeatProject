package com.hb.major.service.bbs.comment;

import org.springframework.ui.Model;

import com.hb.major.model.entity.CommentVo;

public interface CommentService {
	
	void commentList(int postnum, Model model);
	void commentAddOne(CommentVo cmtbean);
	
}
