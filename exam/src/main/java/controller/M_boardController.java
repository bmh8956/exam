package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import m_board.M_boardDAO;
import m_board.M_boardDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("*.mb")
public class M_boardController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public M_boardController() {
        super();
    }
    M_boardDAO dao = new M_boardDAO();

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        res.getWriter().append("Served at: ").append(req.getContextPath());

        //한글이 깨어지지 않도록 처리 ( client ==> server )
        req.setCharacterEncoding("UTF-8");

        //1.
        String uri = req.getRequestURI();
        //System.out.println(uri);
        String path = uri.substring(uri.lastIndexOf("/"));
        //System.out.println(path);

        if(path.equals("/insertPage.mb")) {
            res.sendRedirect("insert_mboard.jsp");
        } else if(path.equals("/insert.mb")) {
            M_boardDTO dto = new M_boardDTO();
            String m_title = req.getParameter("m_title");
            String m_write = req.getParameter("m_write");
            String m_content = req.getParameter("m_content");
            dto.setM_title(m_title);
            dto.setM_write(m_write);
            dto.setM_cont(m_content);

            dao.setInsert(dto);
            res.sendRedirect("mboard_list.mb");
        } else if(path.equals("/mboard_list.mb")) {
            List<M_boardDTO> list = new ArrayList<>();
            list = dao.getList();
            HttpSession session = req.getSession();
            session.setAttribute("list", list);
            res.sendRedirect("mboard_list.jsp");
        } else if(path.equals("/get_mboard.mb")) {
            M_boardDTO dto = new M_boardDTO();
            M_boardDTO mboard = new M_boardDTO();
            int id = Integer.parseInt(req.getParameter("id"));
            dto.setId(id);
            dao.updateCnt(dto);
            mboard = dao.get(dto);

            HttpSession session = req.getSession();
            session.setAttribute("dto", mboard);
            res.sendRedirect("getMboard.jsp");
        } else if(path.equals("/update.mb")) {
            M_boardDTO dto = new M_boardDTO();
            int id = Integer.parseInt(req.getParameter("id"));
            String m_title = req.getParameter("m_title");
            String m_cont = req.getParameter("m_cont");
            dto.setId(id);
            dto.setM_title(m_title);
            dto.setM_cont(m_cont);
            dao.update(dto);
            res.sendRedirect("get_mboard.mb?id=" + id);
        } else if(path.equals("/delete.mb")) {
            M_boardDTO dto = new M_boardDTO();
            int id = Integer.parseInt(req.getParameter("id"));
            dto.setId(id);
            dao.delete(dto);
            res.sendRedirect("mboard_list.mb");
        }
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        doGet(req, res);
    }

}
