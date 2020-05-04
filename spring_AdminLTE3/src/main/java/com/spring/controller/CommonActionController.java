package com.spring.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.dto.MemberVO;
import com.spring.exception.InvalidPasswordException;
import com.spring.exception.NotFoundIDException;
import com.spring.service.MemberService;

@Controller
@RequestMapping("/commons/*")
public class CommonActionController {

	@Autowired
	private MemberService memberService;
	public void setMemberService (MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping("loginForm.do")
	public String loginForm() throws Exception {
		String url="commons/loginForm";
		
		return url;
	}
	
	@RequestMapping("login.do")
	public String login(String id, String pwd, HttpServletRequest request, Model model) throws Exception {
		String url = "redirect:/member/list.do";
		
		HttpSession session = request.getSession();
		
		try {
			memberService.login(id, pwd);
			MemberVO loginUser = memberService.getMember(id);
			session.setAttribute("loginUser", loginUser);
			session.setMaxInactiveInterval(60 * 60);
		} catch (SQLException e) {
			url = "error/500_error";
		} catch (NotFoundIDException e) {
			url="redirect:/commons/loginForm.do";
		} catch (InvalidPasswordException e) {
			url="redirect:/commons/loginForm.do";			
		}
		
		return url;
	}
	
	@RequestMapping("logout.do")
	public String logout(HttpServletRequest request) throws Exception {
		String url = "redirect:/commons/loginForm.do";
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		return url;
	}
	
}
