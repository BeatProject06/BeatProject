package com.hb.major.controller;

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

import com.hb.major.model.entity.QnaVo;
import com.hb.major.service.qna.QnaService;
import com.hb.major.service.qna.comment.QnaCommService;


@Controller
@RequestMapping(value = "question/")
public class QnaController {
private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
@Autowired
private QnaService qnaService; 
@Autowired
private QnaCommService qnaCommService;


	@RequestMapping(value = "/page{qnapage}", method = RequestMethod.GET)
	public String board(Locale locale, Model model, @PathVariable("qnapage") int qnapage) {

		logger.info("질문 게시판", locale);
		model.addAttribute("currentmenu", "question");
		
		//여기서 관리자 맞는지 먼저 체크를 하자
		
		qnaService.qnaListAll(model, qnapage);
		System.out.println("관리자용 질문 게시판 페이지는 " + qnapage);
		return "user/qna/question";
		
	}

	
	@RequestMapping(value = "/{postno}", method = RequestMethod.GET) //상세
	public String detail(Locale locale, Model model, @PathVariable("postno") int no, HttpServletRequest req) {

		logger.info("문의사항 게시글 상세 페이지", locale);

		System.out.println("상세 아이디" + req.getParameter("tempid"));
		model.addAttribute("currentmenu", "question");

		qnaService.qnaDetailOne(no, model);
		qnaCommService.qnaCommentList(no, model);

		return "user/qna/detail";
	}

	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(Locale locale, Model model) {
		model.addAttribute("currentmenu", "question");
		logger.info("문의사항 게시글 작성페이지", locale );
		System.out.println("add 겟 들어옴");
		return "user/qna/write";
	}
	
	
	@RequestMapping(value = "/write/writecom", method = RequestMethod.POST)
	public String writeadd(Locale locale, @ModelAttribute QnaVo bean, HttpServletRequest req, Model model) {
		logger.info("문의사항 게시글 작성", locale);
		System.out.println("add 포스트 들어옴");
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		qnaService.qnaAddOne(bean);
		System.out.println(bean);

		return "redirect:/question/";
	}
	
	@RequestMapping(value = "/{postno}", method = RequestMethod.PUT) //수정페이지로 입장
	public String editpage(Locale locale, Model model, @PathVariable("postno") int no) {

		logger.info("문의사항 수정 페이지", locale);
		model.addAttribute("currentmenu", "question");
		qnaService.qnaDetailOne(no, model);
		
		return "user/qna/edit";
	}
	
	@RequestMapping(value = "/completeedit/{postno}", method = RequestMethod.PUT)//수정 실행
	public String edit(@PathVariable("postno") int no, QnaVo bean, Model model) throws Exception {
		qnaService.qnaUpdateOne(bean);
		System.out.println(bean.getQnaNo()+"번째 글 : " + bean.getQnaTitle() + "," + bean.getQnaContent());
		System.out.println("문의사항 내용 수정");
		
		return "redirect:/question/";
	}
	
	@RequestMapping(value = "/{postno}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("postno") int no, Model model) throws Exception {
		System.out.println("delete처음페이지로");
		qnaService.qnaDetailOne(no, model);
		return "user/qna/delete";
	}

	@RequestMapping(value = "/delete/{postno}", method = RequestMethod.DELETE)
	public String deletecompl(@PathVariable("postno") int no, QnaVo bean, Model model) throws Exception {
	
		qnaService.qnaDeleteOne(no);
		System.out.println(no + "번째 게시글 삭제");
		return "redirect:/question/";
	}
	

	@RequestMapping(value = "/qnasearch", method = RequestMethod.GET)
	protected String bbsSearch(Locale locale, Model model, HttpServletRequest req, HttpServletResponse res) {

		logger.info("게시판 검색", locale);
		try {
			//req.setCharacterEncoding("UTF-8");
			String keyword = req.getParameter("qnasearchkeyword");
			System.out.println(keyword);
			model.addAttribute("currentmenu", "question");
			qnaService.qnaSearch(model, keyword);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "user/qna/question";
	}
	
}
