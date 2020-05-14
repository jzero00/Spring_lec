package com.groupware.controller.board;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.groupware.dto.BoardVO;
import com.groupware.request.SearchCriteria;
import com.groupware.service.board.BoardService;

@Controller
@RequestMapping("/board")
public class FreeBoardController {

	@Autowired
	private BoardService bService;
	
	@RequestMapping("/free/list")
	public ModelAndView freeList(SearchCriteria cri, ModelAndView modelnView) throws SQLException {
		
		String url = "/board/free/free_list";
		
		Map<String, Object> dataMap = bService.getBoardList(cri);
		
		/*
		 *	jsp markup에 직접 주지 않고 controller에서 직접 지정
		 *	사용자에 의해 바뀌지 않는 상황이라고 가정함
		 *	그게 아니고 사용자에 의해 계속 변하는 상황이라면 properties로 key value를 주는것을 추천
		 */
		
		List<ColName> colNames = new ArrayList<ColName>();
		String[] colNameArr = {"번&nbsp;호", "제&nbsp;목", "작성일", "작성자", "조회수"};
		String[] colWidthArr = {"7", "", "15", "15", "10"};
		for(int i = 0; i < colNameArr.length; i++) {
			colNames.add(new ColName(colNameArr[i], colWidthArr[i]));
		}
		
		dataMap.put("colNames", colNames);
		modelnView.addAllObjects(dataMap);
		modelnView.setViewName(url);
		
		return modelnView;
	}
	
	@RequestMapping(value="/free/regist", method=RequestMethod.POST)
	public void freeRegist(BoardVO board, HttpServletResponse response) throws Exception {
		
		bService.write(board);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("window.opener.location.href='/board/free/list';window.close();");
		out.println("</script>");
	}
	
	@RequestMapping("/free/detail")
	public ModelAndView freeDetail(int bno, ModelAndView modelnView) throws SQLException {
		String url = "board/free/free_detail";
		
		BoardVO board = bService.readBoard(bno);
		
		modelnView.addObject("board", board);
		modelnView.setViewName(url);
		
		return modelnView;
	}
	
	@RequestMapping(value="/free/modify", method=RequestMethod.GET)
	public void modiftForm(@ModelAttribute("category") String category, int bno, Model model) throws Exception {
		BoardVO board = bService.getBoardForModify(bno);
		model.addAttribute("board",board);
	}
	
	@RequestMapping(value="/free/modify", method=RequestMethod.POST)
	public void updatePOST(BoardVO board, HttpServletResponse response) throws Exception {
		board.setUpdatedate(new Date());
		
		bService.modify(board);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("window.opener.location.reload();");
		out.println("location.href='detail?bno="+board.getBno()+"';");
		out.println("</script>");
	}
	
	@RequestMapping(value="/free/remove", method=RequestMethod.GET)
	public void remove(int bno, HttpServletResponse response) throws Exception {
		bService.remove(bno);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('"+bno+"번 글이 삭제되었습니다.');");
		out.println("window.opener.location.reload();window.close();");
		out.println("</script>");
	}
}
