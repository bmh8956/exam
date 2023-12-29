package member;

import common.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import member.MemberDTO;

public class MemberDAO {
	Connection conn = null;
    PreparedStatement pstmt = null ;
    ResultSet rs = null ;

    private static final String INSERT_USER =
            "INSERT INTO " +
            "   member(id, password, phone, email, addr, role) " +
            "values(?, ?, ?, ?, ?, ?)";
    
    private static final String MEMBER_LIST =
            "SELECT " +
            "   * " +
            "FROM " +
            "   member ";
    
    private static final String LOGIN =
            "SELECT " +
            "   * " +
            "FROM " +
            "   member " +
            "WHERE " +
            "   id = ? " +
            "AND " +
            "   password = ?";
    
    private static final String GET_MEMBER =
            "SELECT " +
            "   * " +
            "FROM " +
            "   member " +
            "WHERE " +
            "   id = ?";

    private static final String UPDATE_MEMBER =
            "UPDATE " +
            "   member " +
        "   SET " +
            "   id = ?, " +
            "   password = ?, " +
            "   phone = ?, " +
            "   email = ?, " +
            "   addr = ?, " +
            "   role = ? " +
            "WHERE " +
            "   id = ?";

    private static final String DELETE_MEMBER =
            "DELETE " +
            "   member " +
            "WHERE " +
            "   id = ?";
    

    public void insertMember(MemberDTO dto) {
        try {
            conn = JDBCUtil.getConnection() ;
            pstmt = conn.prepareStatement(INSERT_USER);

            pstmt.setString(1, dto.getId());
            pstmt.setString(2, dto.getPassword());
            pstmt.setString(3, dto.getPhone());
            pstmt.setString(4, dto.getEmail());
            pstmt.setString(5, dto.getAddr());
            pstmt.setString(6, dto.getRole());

            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, pstmt, conn);
        }
    }
    
    public List<MemberDTO> getList() {
        List<MemberDTO> list = new ArrayList<>();
        try {
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(MEMBER_LIST) ;

            rs = pstmt.executeQuery();


            while (rs.next()) {
                MemberDTO mb = new MemberDTO();
                mb.setId(rs.getString("id"));
                mb.setPassword(rs.getString("password"));
                mb.setPhone(rs.getString("phone"));
                mb.setRegdate(rs.getString("REGDATE"));
                mb.setAddr(rs.getString("addr"));
                mb.setEmail(rs.getString("email"));
                mb.setRole(rs.getString("role"));

                list.add(mb);
            }


        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs, pstmt, conn);
        }


        return list;
    }
    
    public MemberDTO login(MemberDTO dto) {

        MemberDTO mb = new MemberDTO();
        try {
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(LOGIN) ;
            pstmt.setString(1, dto.getId());
            pstmt.setString(2, dto.getPassword());


            rs = pstmt.executeQuery();

            while (rs.next()) {
                mb.setId(rs.getString("id"));
                mb.setPassword(rs.getString("password"));
                mb.setPhone(rs.getString("phone"));
                mb.setRegdate(rs.getString("REGDATE"));
                mb.setAddr(rs.getString("addr"));
                mb.setEmail(rs.getString("email"));
                mb.setRole(rs.getString("role"));
            }


        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs, pstmt, conn);
        }


        return mb;
    }
    
    public MemberDTO getMember(MemberDTO dto) {
        MemberDTO mb = new MemberDTO();
        try {
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(GET_MEMBER);
            pstmt.setString(1, dto.getId());

            rs = pstmt.executeQuery();

            while (rs.next()) {
                mb.setId(rs.getString("id"));
                mb.setPassword(rs.getString("password"));
                mb.setPhone(rs.getString("phone"));
                mb.setRegdate(rs.getString("REGDATE"));
                mb.setAddr(rs.getString("addr"));
                mb.setEmail(rs.getString("email"));
                mb.setRole(rs.getString("role"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mb;
    }
    
    public void modi(MemberDTO dto) {
        try {
            conn = JDBCUtil.getConnection() ;
            pstmt = conn.prepareStatement(UPDATE_MEMBER);

            pstmt.setString(1, dto.getId());
            pstmt.setString(2, dto.getPassword());
            pstmt.setString(3, dto.getPhone());
            pstmt.setString(4, dto.getEmail());
            pstmt.setString(5, dto.getAddr());
            pstmt.setString(6, dto.getRole());
            pstmt.setString(7, dto.getId());

            pstmt.executeUpdate();
            System.out.println("modi");
            System.out.println(dto);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, pstmt, conn);
        }
    }

    public void delete(MemberDTO dto) {
        try {
            conn = JDBCUtil.getConnection() ;
            pstmt = conn.prepareStatement(DELETE_MEMBER);
            pstmt.setString(1, dto.getId());

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, pstmt, conn);
        }
    }
}
