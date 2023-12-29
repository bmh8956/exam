package product;

import common.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	Connection conn = null;
	PreparedStatement pstmt = null ;
	ResultSet rs = null ;

	public static final String INSERT_PROD =
			"INSERT INTO " +
			"   product(name, price, content) " +
			"VALUES(?, ?, ?)";

	public static final String PROD_LIST =
			"SELECT " +
			"   * " +
			"FROM " +
			"   product " +
			"ORDER BY " +
			"   id desc";

	public static final String GET_PROD =
			"SELECT " +
			"   * " +
			"FROM " +
			"   product " +
			"WHERE " +
			"   id = ?";

	public static final String UPDATE_PROD =
			"UPDATE " +
			"   product " +
			"SET " +
			"   name = ?, " +
			"   price = ?, " +
			"   content = ? " +
			"WHERE" +
			"   id = ?";

	public static final String DELETE_PROD =
			"DELETE " +
			"   product " +
			"WHERE " +
			"   id = ?";


	public void setInsertProd(ProductDTO dto) {
		try {
			conn = JDBCUtil.getConnection() ;
			pstmt = conn.prepareStatement(INSERT_PROD);

			pstmt.setString(1, dto.getName());
			pstmt.setDouble(2, dto.getPrice());
			pstmt.setString(3, dto.getContent());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
	}

	public List<ProductDTO> getList() {
		List<ProductDTO> list = new ArrayList<>();
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(PROD_LIST) ;

			rs = pstmt.executeQuery();

			while (rs.next()) {
				ProductDTO pd = new ProductDTO();
				pd.setId(rs.getInt("id"));
				pd.setName(rs.getString("name"));
				pd.setPrice(rs.getDouble("price"));
				pd.setContent(rs.getString("content"));
				pd.setRegdate(rs.getDate("regdate"));

				list.add(pd);
			}

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return list;
	}

	public ProductDTO getProd(ProductDTO dto) {
		ProductDTO pd = new ProductDTO();
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(GET_PROD) ;
			pstmt.setInt(1, dto.getId());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				pd.setId(rs.getInt("id"));
				pd.setName(rs.getString("name"));
				pd.setPrice(rs.getDouble("price"));
				pd.setContent(rs.getString("content"));
				pd.setRegdate(rs.getDate("regdate"));
			}

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return pd;
	}

	public void update(ProductDTO dto) {
		try {
			conn = JDBCUtil.getConnection() ;
			pstmt = conn.prepareStatement(UPDATE_PROD);

			pstmt.setString(1, dto.getName());
			pstmt.setDouble(2, dto.getPrice());
			pstmt.setString(3, dto.getContent());
			pstmt.setInt(4, dto.getId());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
	}

	public void delete(ProductDTO dto) {
		try {
			conn = JDBCUtil.getConnection() ;
			pstmt = conn.prepareStatement(DELETE_PROD);

			pstmt.setInt(1, dto.getId());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
	}

}

