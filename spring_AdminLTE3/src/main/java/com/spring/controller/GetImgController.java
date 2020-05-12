package com.spring.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping(value="member/picture/get.do", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<byte[]> getMemberProfileImg(String id, Model model) throws Exception {
		ResponseEntity<byte[]> entity = null;
		
		String filePath = GetUploadPath.getUploadPath("member.picture.upload");
		MemberVO member = memberService.getMember(id);
		String fileName = member.getPicture();
		filePath = filePath + fileName;
		
		File picture = new File(filePath);
		
		model.addAttribute("picture", picture);
		
		return entity;
	}
}
