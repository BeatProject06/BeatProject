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
@RequestMapping(value = "board/")
public class BbsController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private BbsService bbsService;
	@Autowired
	private CommentService commentService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String board(Locale locale, Model model) {

		logger.info("게시판", locale);
		model.addAttribute("currentmenu", "board");
		bbsService.bbsListAll(model, 1);
		return "user/bbs/board";
	}

	@RequestMapping(value = "/page{bbspage}", method = RequestMethod.GET)
	public String board(Locale locale, Model model, @PathVariable("bbspage") int bbspage) {

		logger.info("게시판", locale);
		model.addAttribute("currentmenu", "board");
		bbsService.bbsListAll(model, bbspage);
		System.out.println("게시판 페이지는 " + bbspage);

		return "user/bbs/board";
	}

	@RequestMapping(value = "/{postno}", method = RequestMethod.GET) //상세
	public String detail(Locale locale, Model model, @PathVariable("postno") int no, HttpServletRequest req) {

		logger.info("게시글 상세 페이지", locale);

		System.out.println("상세 아이디" + req.getParameter("tempid"));
		model.addAttribute("currentmenu", "board");

		bbsService.bbsDetailOne(no, model);
		commentService.commentList(no, model);

		return "user/bbs/detail";
	}

	@RequestMapping(value = "/{postno}", method = RequestMethod.PUT) //수정페이지로 입장
	public String editpage(Locale locale, Model model, @PathVariable("postno") int no) {

		logger.info("게시글 수정 페이지", locale);
		model.addAttribute("currentmenu", "board");
		bbsService.bbsDetailOne(no, model);

		return "user/bbs/edit";
	}

	@RequestMapping(value = "/completeedit/{postno}", method = RequestMethod.PUT)//수정 실행
	public String edit(@PathVariable("postno") int no, BbsVo bean, Model model) throws Exception {
		bbsService.bbsUpdateOne(bean);
		
		//model.addAttribute("currentmenu", "board");
		System.out.println("내용 수정");
		
		return "redirect:/board/";
	}
	
	@RequestMapping(value = "/{postno}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("postno") int no, Model model) throws Exception {
		System.out.println("delete처음페이지로");
		bbsService.bbsDetailOne(no, model);
		return "user/bbs/delete";
	}

	@RequestMapping(value = "/delete/{postno}", method = RequestMethod.DELETE)
	public String deletecompl(@PathVariable("postno") int no, BbsVo bean, Model model) throws Exception {
	
		//model.addAttribute("currentmenu", "board");
		bbsService.bbsDeleteOne(no);
		System.out.println(no + "번째 게시글 삭제");
		return "redirect:/board/";
	}

	
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(Locale locale, Model model) {
		model.addAttribute("currentmenu", "board");
		logger.info("게시글 작성페이지", locale );
		System.out.println("add 겟 들어옴");
		return "user/bbs/write";
	}

	@RequestMapping(value = "/write/writecom", method = RequestMethod.POST)
	public String writeadd(Locale locale, @ModelAttribute BbsVo bean, HttpServletRequest req, Model model) {
		//model.addAttribute("currentmenu", "board");
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
	protected String bbsSearch(Locale locale, Model model, HttpServletRequest req, HttpServletResponse res) {

		logger.info("게시판 검색", locale);
		try {
			//req.setCharacterEncoding("UTF-8");
			String keyword = req.getParameter("bbssearchkeyword");
			System.out.println(keyword);
			model.addAttribute("currentmenu", "board");
			bbsService.bbsSearch(model, keyword);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "user/bbs/board";
	}

}
