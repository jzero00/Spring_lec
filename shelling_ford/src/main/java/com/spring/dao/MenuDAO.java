package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import com.spring.dto.MenuVO;

public interface MenuDAO {

	public List<MenuVO> getMenuList() throws SQLException;
}
