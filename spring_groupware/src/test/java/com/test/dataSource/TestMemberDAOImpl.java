package com.test.dataSource;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.groupware.dao.employee.EmployeeDAO;
import com.groupware.dto.EmployeeVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/com/spring/context/root-context.xml")
@TransactionConfiguration(transactionManager="transactionManager")
@Transactional
public class TestMemberDAOImpl {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Test
	public void testSelectMember() throws SQLException {
		String id = "mimi";
		
		EmployeeVO member = employeeDAO.selectEmployeeById(id);
		
		Assert.assertEquals(id, member.getId());
	}
	
	@Test
	public void testInsertMember() throws SQLException {
		EmployeeVO member = new EmployeeVO();
		member.setId("kaka");
		member.setPwd("kaka");
		member.setName("kaka");
		member.setEmail("kaka@kaka.com");

		
		employeeDAO.insertEmployee(member);
		
		EmployeeVO result = employeeDAO.selectEmployeeById("kaka");
		
		Assert.assertEquals(member.getId(), result.getId());
	}
}
