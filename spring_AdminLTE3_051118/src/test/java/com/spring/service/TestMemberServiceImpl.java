package com.spring.service;

import org.junit.Before;

import com.spring.dao.MemberDAO;

public class TestMemberServiceImpl {
	
	private MemberDAO memberDAO = new MockMemberDAO();
	
	private MemberServiceImpl service;
	
	@Before
	public void init() {
		service = new MemberServiceImpl();
		service.setMemberDAO(new MockMemberDAO());
	}
}
