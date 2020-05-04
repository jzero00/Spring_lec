package com.spring.request;

import com.spring.dto.PdsVO;

public class PdsRegistRequest {

	private String writer;
	private String title;
	private String content;

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public PdsVO toPdsVO(String writer, String title, String content) {
		PdsVO pds = new PdsVO();
		pds.setContent(content);
		pds.setTitle(title);
		pds.setWriter(writer);
		return pds;	
	}
}
