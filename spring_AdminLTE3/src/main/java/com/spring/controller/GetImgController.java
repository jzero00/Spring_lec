package com.spring.controller;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.utils.GetUploadPath;
import com.spring.utils.MediaUtils;

@Controller
public class GetImgController {
	
	@RequestMapping(value="member/picture/get.do", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<byte[]> getMemberProfileImg(@RequestParam("picture") String fileName) throws Exception {
		ResponseEntity<byte[]> entity = null;
		InputStream in = null;
		
		try {
			String filePath = GetUploadPath.getUploadPath("member.picture.upload");
			filePath = filePath + fileName;
			String formatName = filePath.substring(filePath.lastIndexOf(".")+1);
			MediaType mType = MediaUtils.getMediaType(formatName);
			HttpHeaders headers = new HttpHeaders();
			
			in = new FileInputStream(filePath);
			
			if(mType != null) {
				headers.setContentType(mType);
			} else {
				fileName = fileName.substring(fileName.indexOf("$$") + 1);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-Disposition", "attachment;filename=\""
						+new String(fileName.getBytes("utf-8"),"ISO-8859-1")
						+"\"");
			}
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),headers,HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
			if(in != null) in.close();
		}

		
		return entity;
	}
}
