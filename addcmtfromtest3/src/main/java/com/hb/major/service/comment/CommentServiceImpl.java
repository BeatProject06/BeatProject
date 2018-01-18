package com.hb.major.service.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.hb.major.model.bbs.BbsDao;
import com.hb.major.model.comment.CommentDao;
import com.hb.major.model.entity.CommentVo;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	CommentDao commentDao;
	
	
	@Override
	public void commentList(int postnum, Model cmtmodel) { //게시글에 코멘트 가져오기
	
			try {
				//System.out.println("코멘트 리스트 불러오기 서비스"+commentDao.getCommentList(postnum));//게시글 번호로 그 게시글의 코멘트 가져옴
				cmtmodel.addAttribute("cmtlist", commentDao.getCommentList(postnum));
			} catch (Exception e) {
				e.printStackTrace();
			} 
		
	}
	
	

	@Override
	public void commentAddOne(CommentVo cmtbean){//코멘트 달기
		
		try {
			System.out.println("코멘트 서비스 들어옴");
			commentDao.commentInsertOne(cmtbean);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
