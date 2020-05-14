package com.spring.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dto.MemberVO;
import com.spring.exception.InvalidPasswordException;
import com.spring.exception.NotFoundIDException;
import com.spring.service.MemberService;

@Controller
@RequestMapping("/commons/*")
public class CommonsActionController {

	@Autowired
	private MemberService memberService;
	public void setMemberService (MemberService memberService) {
		this.memberService = memberService;
	}
	
//	@RequestMapping(value = {"/","loginForm.do"})
	@RequestMapping(value = {"/","loginForm.do"})
	public String loginForm(Model model) throws Exception {
		String url="commons/loginForm";
		model.addAttribute("title","로그인");
		return url;
	}
	
	@RequestMapping(value="login.do",method=RequestMethod.POST)
	public String login(String id, String pwd, HttpServletRequest request, Model model) throws Exception {
		String url = "redirect:/member/list.do";
		
		HttpSession session = request.getSession();

		//로그인 실패시 추가한 attribute를 삭제
		session.removeAttribute("msg");
		
		String message = null;
		
		try {
			memberService.login(id, pwd);
			MemberVO loginUser = memberService.getMember(id);
			
			if(loginUser.getEnabled() == 0) { //사용중지
				message = "사용중지된 아이디로 이용이 제한됩니다.";
				url = "redirect:/commons/loginForm.do";
			} else { // 사용 가능
				session.setAttribute("loginUser", loginUser);
				session.setMaxInactiveInterval(60 * 60);				
			}
		} catch (SQLException e) {
			url = "error/500_error";
		} catch (NotFoundIDException e) {
			message = "존재하지 않는 ID입니다.";
			url="redirect:/commons/loginForm.do";
		} catch (InvalidPasswordException e) {
			url="redirect:/commons/loginForm.do";			
		}
		
		return url;
	}
	
	@RequestMapping("logout.do")
	public String logout(Model model, HttpSession session) throws Exception {
		String url = "commons/loginout";
		
		session.invalidate();
		model.addAttribute("msg", "로그아웃되었습니다.");
		
		return url;
	}	
}
