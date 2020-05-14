package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.spring.dto.BoardVO;
import com.spring.request.SearchCriteria;

public class BoardDAOImpl implements BoardDAO {
	
	private SqlSession sqlSession;
	public void setSqlSession (SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<BoardVO> selectBoardCriteria(SearchCriteria cri) throws SQLException {

		int offset = cri.getPageStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);

		List<BoardVO> boardList = sqlSession.selectList("Board-Mapper.selectBoardCriteria", cri, rowBounds);

		return boardList;
	}

	@Override
	public int selectBoardCriteriaTotalCount(SearchCriteria cri) throws SQLException {

		int count = sqlSession.selectOne("Board-Mapper.selectBoardCriteriaTotalCount", cri);

		return count;
	}

	@Override
	public BoardVO selectBoardByBno(int bno) throws SQLException {
		BoardVO board = sqlSession.selectOne("Board-Mapper.selectBoardByBno", bno);

		return board;
	}

	@Override
	public void insertBoard(BoardVO board) throws SQLException {
		sqlSession.update("Board-Mapper.insertBoard", board);
	}

	@Override
	public void updateBoard(BoardVO board) throws SQLException {
		sqlSession.update("Board-Mapper.updateBoard", board);
	}

	@Override
	public void deleteBoard(int bno) throws SQLException {
		sqlSession.update("Board-Mapper.deleteBoard", bno);
	}

	@Override
	public void increaseViewCnt(int bno) throws SQLException {
		sqlSession.update("Board-Mapper.increaseViewCnt", bno);
	}

	@Override
	public int selectBoardSeqNext() throws SQLException {
		int seq_num = sqlSession.selectOne("Board-Mapper.selectBoardSeqNext");
		return seq_num;
	}

	@Override
	public void modifyViewCntForModify(int bno) throws SQLException {
		sqlSession.update("Board-Mapper.modifyViewCntForModify", bno);
	}
}
