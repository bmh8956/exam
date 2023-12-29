package controller;

import member.MemberDAO;
import member.MemberDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("*.us")
public class MemberController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MemberController() {
        super();
    }
    MemberDAO dao = new MemberDAO();

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        res.getWriter().append("Served at: ").append(req.getContextPath());

        //한글이 깨어지지 않도록 처리 ( client ==> server )
        req.setCharacterEncoding("UTF-8");

        //1.
        String uri = req.getRequestURI();
        //System.out.println(uri);
        String path = uri.substring(uri.lastIndexOf("/"));
        System.out.println(path);


        if(path.equals("/join.us")) {
        	System.out.println("join");
            res.sendRedirect("join.jsp");
        } else if(path.equals("/insertUser.us")) {
        	System.out.println("insertUser");
            MemberDTO dto = new MemberDTO();
            String id = req.getParameter("id");
            String password = req.getParameter("password");
            String phone = req.getParameter("phone");
            String email = req.getParameter("email");
            String addr = req.getParameter("addr");
            String role = req.getParameter("role");
            dto.setId(id);
            dto.setPassword(password);
            dto.setPhone(phone);
            dto.setEmail(email);
            dto.setAddr(addr);
            dto.setRole(role);
            
            dao.insertMember(dto);
            res.sendRedirect("memberList.us");
        } else if(path.equals("/memberList.us")) {
        	List<MemberDTO> list = new ArrayList<>();
            list = dao.getList();
            System.out.println(list);
            HttpSession session = req.getSession();
            session.setAttribute("list", list);
            res.sendRedirect("memberList.jsp");
        } else if(path.equals("/loginPage.us")) {
            res.sendRedirect("login.jsp");
        } else if(path.equals("/login.us")) {
            MemberDTO dto = new MemberDTO();
            String id = req.getParameter("id");
            String pw = req.getParameter("password");
            dto.setId(id);
            dto.setPassword(pw);

            MemberDTO member = dao.login(dto);
            HttpSession session = req.getSession();
            session.setAttribute("login", member);
            res.sendRedirect("index.jsp");
        } else if(path.equals("/getMember.us")) {
            MemberDTO dto = new MemberDTO();
            MemberDTO mb = new MemberDTO();
            String id = req.getParameter("id");
            dto.setId(id);
            mb = dao.getMember(dto);
            HttpSession session = req.getSession();
            session.setAttribute("dto", mb);
            res.sendRedirect("getMember.jsp");
        } else if(path.equals("/updateMember.us")) {
        	MemberDTO dto = new MemberDTO();
            MemberDTO mb = new MemberDTO();
            String id = req.getParameter("id");
            dto.setId(id);
            mb = dao.getMember(dto);
            HttpSession session = req.getSession();
            session.setAttribute("dto", mb);
            res.sendRedirect("updateMember.jsp");
        } else if(path.equals("/modi.us")) {
            MemberDTO dto = new MemberDTO();

            String id = req.getParameter("id");
            String password = req.getParameter("password");
            String phone = req.getParameter("phone");
            String email = req.getParameter("email");
            String addr = req.getParameter("addr");
            String role = req.getParameter("role");
            dto.setId(id);
            dto.setPassword(password);
            dto.setPhone(phone);
            dto.setEmail(email);
            dto.setAddr(addr);
            dto.setRole(role);

            dao.modi(dto);

            res.sendRedirect("getMember.us?id=" + id);
        } else if(path.equals("/delete.us")) {
            MemberDTO dto = new MemberDTO();
            String id = req.getParameter("id");

            dto.setId(id);
            dao.delete(dto);

            res.sendRedirect("memberList.us");
        } else if(path.equals("/logout.us")) {
            HttpSession session = req.getSession();
            session.invalidate();
            res.sendRedirect("http://localhost:8282/test/");
        }



    }


    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        doGet(req, res);
    }

}
