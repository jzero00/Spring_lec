package com.spring.controller;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.reflection.invoker.GetFieldInvoker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.dto.MemberVO;
import com.spring.request.SearchCriteria;
import com.spring.service.MemberService;
import com.spring.utils.GetUploadPath;

@Controller
@RequestMapping("/member/*")
public class MemberActionController {
	
	@Autowired
	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping("list.do")
	public String list(SearchCriteria cri, Model model/*HttpServletRequest request*/) throws Exception {
		String url = "/member/list.page";
		Map<String, Object> dataMap = memberService.getMemberList(cri);
		
		/*모델 쓰기 전*/
		/*request.setAttribute("pageMaker", (PageMaker) dataMap.get("pageMaker"));
		request.setAttribute("memberList", (List<MemberVO>) dataMap.get("memberList"));*/
		
		/*모델 등장 두둥?
		model.addAttribute("pageMaker", (PageMaker) dataMap.get("pageMaker"));
		model.addAttribute("memberList", (List<MemberVO>) dataMap.get("memberList"));*/
		
		/*통째로 한번에 넣고싶어 욕심쟁이 같은 녀석이라고*/
		model.addAllAttributes(dataMap);
		return url;
	}
	
	@RequestMapping("detail.do")
	public String detail(String id, Model model) throws Exception{
		String url = "/member/detail.open";
		
		MemberVO member = memberService.getMember(id);
		model.addAttribute("member", member);
		
		return url;
	}
	
	@RequestMapping("modifyForm.do")
	public String modifyForm(String id, Model model) throws Exception {
		String url = "/member/modify.open";
		
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
	
	@RequestMapping("abled.do")
	public String enabled(String id, Model model) throws Exception {
		String url = "/member/abled_success";
		
		try {
			memberService.enabled(id);
			model.addAttribute("id", id);
		} catch (SQLException e) {
			url = "/member/abled_fail";
		}
		return url;
	}
	
	@RequestMapping("disabled.do")
	public String disabled(String id, Model model) throws Exception {
		String url = "/member/disabled_success";
		
		try {
			memberService.disabled(id);
			model.addAttribute("id", id);
		} catch (SQLException e) {
			url = "/member/disabled_fail";
		}
		return url;
	}
	
	@RequestMapping("picture/get.do")
	public void memberPicture(String id, Model model) throws Exception {
		MemberVO member = memberService.getMember(id);
		
		String fileName = member.getPicture();
		String filePath = GetUploadPath.getUploadPath("member.picture.upload");
		filePath = filePath + fileName;
	}

	
}
