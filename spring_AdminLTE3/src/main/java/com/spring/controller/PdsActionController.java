package com.spring.controller;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.dto.AttachVO;
import com.spring.dto.PdsVO;
import com.spring.request.SearchCriteria;
import com.spring.service.PdsService;
import com.spring.utils.GetUploadPath;

@Controller
@RequestMapping("/pds/*")
public class PdsActionController {

	@Autowired
	private PdsService pdsService;
	public void setPdsService (PdsService pdsService) {
		this.pdsService = pdsService;
	}
	
	@RequestMapping("list.do")
	public void list(Model model, SearchCriteria cri) throws Exception {
		Map<String, Object> dataMap = pdsService.getList(cri);

		model.addAttribute("dataMap", dataMap);
		
	
	}
	
	@RequestMapping("registForm.do")
	public String registForm() throws Exception {
		String url = "pds/regist";
		
		return url;
	}
	
	@RequestMapping("detail.do")
	public String detail(int pno, Model model) throws Exception {
		String url = "pds/detail";
		
		PdsVO pds = pdsService.getPds(pno);
		model.addAttribute("pds", pds);
		
		return url;
	}
	
	@RequestMapping("remove.do")
	public String remove(int pno) throws Exception {
		String url = "pds/remove_success";
		try {
			
			pdsService.remove(pno);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}
	
	@RequestMapping(value="regist.do", method=RequestMethod.POST, consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public String regist(PdsVO pds, @RequestParam("uploadFile") List<MultipartFile> fileList) throws Exception {
		
		sendFile(pds, fileList);		
//		pdsService.regist(pds);
		return null;
	}
	
	@RequestMapping(value="modifyForm.do", method=RequestMethod.GET)
	public ModelAndView modifyForm(ModelAndView mnv, int pno) throws Exception {
		String url = "pds/modify";
		
		PdsVO pds = pdsService.getPds(pno);
		mnv.setViewName(url);
		mnv.addObject("pds", pds);
		
		return mnv;
	}

	private void sendFile(PdsVO pds, List<MultipartFile> fileList) throws Exception{
		List<AttachVO> attachList = new ArrayList<AttachVO>();
		for(MultipartFile file : fileList) {
			// 파일 이름, 경로, 타입 추출
			String fileName = file.getOriginalFilename();
			String uploadPath = GetUploadPath.getUploadPath("pds.upload");
			fileName = UUID.randomUUID().toString() + "$$" + fileName;
			String fileType = fileName.substring(fileName.lastIndexOf(".")+1);
//			System.out.println("FileName : " + fileName );
//			System.out.println("uploadPath : " + uploadPath );
//			System.out.println("fileType : " + fileType );
			
			//중복체크
			
			
			//VO에 setting
			AttachVO attach = new AttachVO();
			attach.setFileName(fileName);
			attach.setUploadPath(uploadPath);
			attach.setFileType(fileType);
			attachList.add(attach);
			
			File saveFile = new File(uploadPath,fileName);
			file.transferTo(saveFile);
		}
		
		try {
			// DB 업로드
			pds.setAttachList(attachList);
			pdsService.regist(pds);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
