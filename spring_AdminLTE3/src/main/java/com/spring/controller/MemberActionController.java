package com.spring.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dto.MemberVO;
import com.spring.request.PageMaker;
import com.spring.request.SearchCriteria;
import com.spring.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberActionController {
	
	@Autowired
	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping("list.do")
	public void list(SearchCriteria cri, Model model/*HttpServletRequest request*/) throws Exception {
		
		Map<String, Object> dataMap = memberService.getMemberList(cri);
		
		/*모델 쓰기 전*/
		/*request.setAttribute("pageMaker", (PageMaker) dataMap.get("pageMaker"));
		request.setAttribute("memberList", (List<MemberVO>) dataMap.get("memberList"));*/
		
		/*모델 등장 두둥?
		model.addAttribute("pageMaker", (PageMaker) dataMap.get("pageMaker"));
		model.addAttribute("memberList", (List<MemberVO>) dataMap.get("memberList"));*/
		
		/*통째로 한번에 넣고싶어 욕심쟁이 같은 녀석이라고*/
		model.addAllAttributes(dataMap);
	}
	
	@RequestMapping("detail.do")
	public String detail(String id, Model model) throws Exception{
		String url = "/member/detail";
		
		MemberVO member = memberService.getMember(id);
		model.addAttribute("member", member);
		
		return url;
	}
	
	@RequestMapping("modifyForm.do")
	public String modifyForm(String id, Model model) throws Exception {
		String url = "/member/modify";
		
		MemberVO member = memberService.getMember(id);
		model.addAttribute("member", member);
		
		return url;
	}
	
	@RequestMapping("modify.do")
	public String modify(MemberVO member, Model model) throws Exception {
		String url = "/member/modify_success";
		
		try {
			memberService.modify(member);
			model.addAttribute("id", member.getId());
			model.addAttribute("member", member);
		} catch (SQLException e) {
			url = "/member/modify_fail";
		}
		
		return url;
	}
	
	@RequestMapping("remove.do")
	public String remove(String id) throws Exception {
		String url = "/member/remove_success";
		
		try {
			memberService.remove(id);
		} catch (SQLException e) {
			url = "redirect:/member/detail.do?id=" + id;
		}
		
		return url;
	}
	
}
