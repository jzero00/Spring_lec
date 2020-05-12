package com.test.dataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 이 테스트를 하는 이유
 * ojdbc에서 에러가 나는지 myBatis에서 에러가 나는지 확인할 수 있음
 * 먼저 ojdbc먼저 테스트하는 것
 */

@RunWith(SpringJUnit4ClassRunner.class)
/**
 * Spring containor를 만들어주는 녀석
 */
@ContextConfiguration("classpath:com/groupware/context/root-context.xml")
public class TestBasicDataSource {
	/**
	 * context에 있는 dataSource를 가져올수 있게 됨
	 */
	@Autowired
	private BasicDataSource dataSource;
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	/**
	 * test할때마다 실행
	 * test할때마다 connection 가져와야하니까
	 */
	@Before
	public void init() throws SQLException{
		conn = dataSource.getConnection();
	}
	
	/**
	 * test 주의사항
	 * public void throws Exception
	 * @throws SQLException
	 */
	@Test
	public void testConnection() throws SQLException{
		Connection conn = this.conn;
		
		Assert.assertNotEquals(null, conn);
	}
	
	/*@Test
	public void testSqlInjection()throws SQLException{		
		
		final String id="mimi";
		
		String sql="select * from member where id='"+id+"'";
		
		this.stmt = this.conn.createStatement();
		this.rs = this.stmt.executeQuery(sql);
		
		MemberVO member=null;
		if(rs.next()){
			member = new MemberVO();
			member.setId(rs.getString("id"));
		}
		
		Assert.assertEquals(id, member.getId());		
	}*/

	@After  
	public void end()throws SQLException{
		if(rs!=null)	rs.close();
		if(stmt!=null)	stmt.close();
		if(conn!=null)	conn.close();
	}
}
