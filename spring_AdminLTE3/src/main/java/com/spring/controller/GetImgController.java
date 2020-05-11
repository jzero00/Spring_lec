package com.spring.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.dto.MemberVO;
import com.spring.service.MemberService;
import com.spring.utils.GetUploadPath;

@Controller
public class GetImgController {

	@Autowired
	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping("member/picture/get.do")
	public void getMemberProfileImg(String id, Model model) throws Exception {
		String filePath = GetUploadPath.getUploadPath("member.picture.upload");
		MemberVO member = memberService.getMember(id);
		String fileName = member.getPicture();
		filePath = filePath + fileName;
		
		File picture = new File(filePath);
		
		model.addAttribute("picture", picture);
	}
}
