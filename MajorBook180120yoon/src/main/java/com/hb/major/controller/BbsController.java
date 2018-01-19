package com.hb.major.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hb.major.model.entity.BbsVo;
import com.hb.major.service.bbs.BbsService;
import com.hb.major.service.comment.CommentService;

@Controller
@RequestMapping(value="board/")
public class BbsController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private BbsService bbsService;
	@Autowired
	private CommentService commentService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String board(Locale locale, Model model) {

		logger.info("게시판", locale);

		bbsService.bbsListAll(model, 1);
		return "user/board";
	}

	@RequestMapping(value = "/{bbspage}", method = RequestMethod.GET)
	public String board(Locale locale, Model model, @PathVariable("bbspage") int bbspage) {

		logger.info("게시판", locale);
		//System.out.println("게시판페이지는 " + bbspage);
		bbsService.bbsListAll(model, bbspage);


		return "user/board";
	}
	
	
	
	
	@RequestMapping(value = "/detail/{postno}", method = RequestMethod.GET)
	public String detail(Locale locale, Model model, Model cmtmodel, @PathVariable("postno") int no) {

		logger.info("게시글상세페이지", locale);
		bbsService.bbsDetailOne(no, model);
		
		commentService.commentList(no, cmtmodel);

		return "user/detail";
	}
	

	@RequestMapping(value = "/edit/{postno}", method = RequestMethod.GET)
	public String editpage(Locale locale, Model model, @PathVariable("postno") int no) {

		logger.info("게시글수정페이지", locale);
		bbsService.bbsDetailOne(no, model);

		return "user/edit";
	}

	@RequestMapping(value = "/edit/{postno}", method = RequestMethod.PUT)
	public String edit(@PathVariable("postno") int no, BbsVo bean) throws Exception {
		bbsService.bbsUpdateOne(bean);
		System.out.println("내용수정");
		return "redirect:/board/";
	}

	@RequestMapping(value = "/delete/{postno}", method = RequestMethod.GET)
	public String delete(@PathVariable("postno") int no, Model model) throws Exception {
		bbsService.bbsDetailOne(no, model);
		return "user/delete";
	}
	
	@RequestMapping(value = "/delete/{postno}", method = RequestMethod.DELETE)
	public String deletecompl(@PathVariable("postno") int no, BbsVo bean) throws Exception {
		bbsService.bbsDeleteOne(no);
		System.out.println(no+"번째 게시글 삭제");
		return "redirect:/board/";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write(Locale locale, Model model) {
		logger.info("게시글 작성페이지", locale);
		 		System.out.println("add 겟 들어옴");
		 
		return "user/write";
	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String writeadd(Locale locale, @ModelAttribute BbsVo bean, HttpServletRequest req) {
		
		logger.info("게시글 작성", locale);
		 System.out.println("add 포스트 들어옴");
		 		
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		bbsService.bbsAddOne(bean);
		System.out.println(bean);

		return "redirect:/board/";
	}
	
	
	@RequestMapping(value = "/bbssearch", method = RequestMethod.GET)
	protected String bbsSearch (Locale locale, Model model, HttpServletRequest req, HttpServletResponse res) {
		
		logger.info("게시판 검색", locale);
		try {
			req.setCharacterEncoding("UTF-8"); 
			String keyword = req.getParameter("bbssearchkeyword");
			
			bbsService.bbsSearch(model, keyword);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "user/board";
		
	}
	
	
	
	
	
	
}
