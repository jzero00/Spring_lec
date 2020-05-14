package com.spring.controller;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.dto.ReplyVO;
import com.spring.request.PageMaker;
import com.spring.request.ReplyDeleteRequest;
import com.spring.request.ReplyModifyRequest;
import com.spring.request.ReplyRegistRequest;
import com.spring.request.SearchCriteria;
import com.spring.service.ReplyService;

@Controller
@RequestMapping("/replies/*")
public class ReplyActionController {

	@Autowired
	private ReplyService replyService;
	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}
	/*기존 방법*/
/*	@RequestMapping("list.do")
	public void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String url = null;
		
		int bno	= Integer.parseInt(request.getParameter("bno"));
		int page= Integer.parseInt(request.getParameter("page"));
		
		SearchCriteria cri = new SearchCriteria();
		cri.setPage(page);
		cri.setPerPageNum(10);
		try {
			Map<String,Object> dataMap = replyService.getReplyList(bno, cri);
			
			ObjectMapper mapper=new ObjectMapper();
			
			response.setContentType("application/json;charset=utf-8");
			PrintWriter out=response.getWriter();
			
			out.println(mapper.writeValueAsString(dataMap));
			
			out.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
//		return url;
	}*/
		
	@RequestMapping("list.do")
	@ResponseBody	/* 화면 url로 리턴 안하고 String으로 리턴함 body에 붙여줌
					   ** jackson databind와 같이 사용할때 **
	 				   댓글 받을때, 파라미터 받고 내보내는게 복잡
	 				   jackson에서 Map 정보를 JSON으로 변환해서 String으로 바꿔줌
	 				   그 데이터를 adaptor에서 처리*/
	public ResponseEntity<Map<String, Object>> list(int bno, SearchCriteria cri) throws Exception {
		ResponseEntity<Map<String, Object>> entity = null;
		
		try {
//			if(true) throw new SQLException();
			Map<String, Object> dataMap = replyService.getReplyList(bno, cri);
			entity = new ResponseEntity<Map<String,Object>>(dataMap, HttpStatus.OK);
		} catch (SQLException e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String,Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return entity;
	}
	
	/*
	 * RequestBody
	 * body에 심어진 request를 String으로 줌
	 * invoke는 String을 꺼내는 역할만 함
	 */
	@RequestMapping("regist.do")
	@ResponseBody		
	public ResponseEntity<Integer> regist(@RequestBody ReplyRegistRequest registReq) throws Exception {

		//String result = "";
		ResponseEntity<Integer> entity = null;
		
		ReplyVO reply = registReq.toReplyVO();
		try {
			replyService.registReply(reply);	
			
//			if(true) throw new SQLException();
			
			SearchCriteria cri = new SearchCriteria();
			Map<String,Object> dataMap = replyService.getReplyList(registReq.getBno(), cri);
			PageMaker pageMaker = (PageMaker) dataMap.get("pageMaker");
			int realEndPage = pageMaker.getRealEndPage();
			
			dataMap.put("realEndPage", pageMaker.getRealEndPage());
			
			entity = new ResponseEntity<Integer>(realEndPage, HttpStatus.OK);
			
//			result = "SUCCESS,"+realEndPage;
			
		} catch (SQLException e) {
			e.printStackTrace();
//			result = "FAIL,1";
			entity = new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
	}
	
	@RequestMapping("modify.do")
	@ResponseBody
	public ResponseEntity<String> modify(@RequestBody ReplyModifyRequest modifyReq) throws Exception {
		ResponseEntity<String> entity = null;
		
		ReplyVO reply = modifyReq.toReplyVO();
		
		try {
			replyService.modifyReply(reply);	
			
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch(SQLException e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
	}
	
	@RequestMapping("remove.do")
	@ResponseBody
	public ResponseEntity<Integer> remove(@RequestBody ReplyDeleteRequest removeReq) throws Exception {
		ResponseEntity<Integer> entity = null;
		
		try {
		replyService.removeReply(removeReq.getRno());
		
		SearchCriteria cri = new SearchCriteria();
		
		Map<String,Object> dataMap = replyService.getReplyList(removeReq.getBno(), cri);
		PageMaker pageMaker = (PageMaker) dataMap.get("pageMaker");
		int page = removeReq.getPage();
		int realEndPage = pageMaker.getRealEndPage();
		if(page > realEndPage) {page = realEndPage;}
		dataMap.put("realEndPage", pageMaker.getRealEndPage());
		entity = new ResponseEntity<Integer>(page, HttpStatus.OK);
		
		} catch (SQLException e) {
			e.printStackTrace();
			entity = new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
	}
	
}
