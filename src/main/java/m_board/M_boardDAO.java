package m_board;

import common.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class M_boardDAO {
	Connection conn = null;
	PreparedStatement pstmt = null ;
	ResultSet rs = null ;

	public static final String INSERT =
			"INSERT INTO " +
			"   m_board(m_title, m_write, m_cont) " +
			"VALUES(?, ?, ?)";

	public static final String LIST =
			"SELECT " +
			"   * " +
			"FROM " +
			"   m_board " +
			"ORDER BY" +
			"   id desc";

	public static final String GET =
			"SELECT " +
			"   * " +
			"FROM " +
			"   m_board " +
			"WHERE " +
			"   id = ?";

	public static final String UPDATE_CNT =
			"UPDATE " +
			"   m_board " +
			"SET " +
			"   cnt = cnt + 1 " +
			"WHERE " +
			"   id = ?";

	public static final String UPDATE =
			"UPDATE " +
			"   m_board " +
			"SET " +
			"   m_title = ?, " +
			"   m_cont = ? " +
			"WHERE " +
			"   id = ?";

	public static final String DELETE =
			"DELETE " +
			"   m_board " +
			"WHERE " +
			"   id = ?";


	public void setInsert(M_boardDTO dto) {
		try {
			conn = JDBCUtil.getConnection() ;
			pstmt = conn.prepareStatement(INSERT);

			pstmt.setString(1, dto.getM_title());
			pstmt.setString(2, dto.getM_write());
			pstmt.setString(3, dto.getM_cont());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
	}

	public List<M_boardDTO> getList() {
		List<M_boardDTO> list = new ArrayList<>();
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(LIST) ;

			rs = pstmt.executeQuery();

			while (rs.next()) {
				M_boardDTO mb = new M_boardDTO();
				mb.setId(rs.getInt("id"));
				mb.setM_title(rs.getString("m_title"));
				mb.setM_write(rs.getString("m_write"));
				mb.setM_cont(rs.getString("m_cont"));
				mb.setRegdate(rs.getDate("regdate"));
				mb.setCnt(rs.getInt("cnt"));

				list.add(mb);
			}

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return list;
	}

	public M_boardDTO get(M_boardDTO dto) {
		M_boardDTO mb = new M_boardDTO();
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(GET) ;
			pstmt.setInt(1, dto.getId());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				mb.setId(rs.getInt("id"));
				mb.setM_title(rs.getString("m_title"));
				mb.setM_write(rs.getString("m_write"));
				mb.setM_cont(rs.getString("m_cont"));
				mb.setRegdate(rs.getDate("regdate"));
				mb.setCnt(rs.getInt("cnt"));
			}

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return mb;
	}

	public void updateCnt(M_boardDTO dto) {
		try {
			conn = JDBCUtil.getConnection() ;
			pstmt = conn.prepareStatement(UPDATE_CNT);

			pstmt.setInt(1, dto.getId());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
	}

	public void update(M_boardDTO dto) {
		try {
			conn = JDBCUtil.getConnection() ;
			pstmt = conn.prepareStatement(UPDATE);

			pstmt.setString(1, dto.getM_title());
			pstmt.setString(2, dto.getM_cont());
			pstmt.setInt(3, dto.getId());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
	}

	public void delete(M_boardDTO dto) {
		try {
			conn = JDBCUtil.getConnection() ;
			pstmt = conn.prepareStatement(DELETE);

			pstmt.setInt(1, dto.getId());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
	}

}

