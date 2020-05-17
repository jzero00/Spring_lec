package com.groupware.security;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.groupware.dto.EmployeeVO;
import com.groupware.service.employee.EmployeeService;

public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	
	/**
	 * 이거 안되는 이유
	 * 같이 bean등록하고 있어서..
	 */
//	private EmployeeService employeeService;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/groupware/context/root-context.xml");
		EmployeeService service = (EmployeeService) ctx.getBean("employeeService");
		
		String id = authentication.getName();
		
		try {
			EmployeeVO loginUser = (EmployeeVO) service.getEmployee(id).get("employee");
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//super();의 의미 : 너 하던대로 해 !! 나는 tomcat의 session만 살짝 조작해서 넣어주기
		super.onAuthenticationSuccess(request, response, authentication);
		
	}

}
