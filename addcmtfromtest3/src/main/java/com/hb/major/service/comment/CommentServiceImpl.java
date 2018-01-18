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
	public void commentList(int postnum, Model cmtmodel) { //�Խñۿ� �ڸ�Ʈ ��������
	
			try {
				//System.out.println("�ڸ�Ʈ ����Ʈ �ҷ����� ����"+commentDao.getCommentList(postnum));//�Խñ� ��ȣ�� �� �Խñ��� �ڸ�Ʈ ������
				cmtmodel.addAttribute("cmtlist", commentDao.getCommentList(postnum));
			} catch (Exception e) {
				e.printStackTrace();
			} 
		
	}
	
	

	@Override
	public void commentAddOne(CommentVo cmtbean){//�ڸ�Ʈ �ޱ�
		
		try {
			System.out.println("�ڸ�Ʈ ���� ����");
			commentDao.commentInsertOne(cmtbean);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
