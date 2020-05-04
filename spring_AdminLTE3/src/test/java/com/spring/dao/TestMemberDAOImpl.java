package com.spring.dao;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSessionException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.spring.dao.MemberDAO;
import com.spring.dto.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/com/spring/context/root-context.xml")
@TransactionConfiguration(transactionManager="transactionManager")

public class TestMemberDAOImpl {

	@Autowired
	private MemberDAO memberDAO;
	
	@Test
	public void testSelectMember() throws SQLException {
		String id = "mimi";
		
		MemberVO member = memberDAO.selectMemberById(id);
		
		Assert.assertEquals(id, member.getId());
	}
	
	@Test
	public void testInsertMember() throws SQLException {
		MemberVO member = new MemberVO();
		member.setId("kaka");
		member.setPwd("kaka");
		member.setName("kaka");
		member.setEmail("kaka@kaka.com");
		member.setPhone("000-0000-0000");
		
		memberDAO.insertMember(member);
		
		MemberVO result = memberDAO.selectMemberById("kaka");
		
		Assert.assertEquals(member.getId(), result.getId());
	}
}
