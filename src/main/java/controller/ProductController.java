package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import product.ProductDAO;
import product.ProductDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("*.pd")
public class ProductController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ProductController() {
        super();
    }
    ProductDAO dao = new ProductDAO();

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        res.getWriter().append("Served at: ").append(req.getContextPath());

        //한글이 깨어지지 않도록 처리 ( client ==> server )
        req.setCharacterEncoding("UTF-8");

        //1.
        String uri = req.getRequestURI();
        //System.out.println(uri);
        String path = uri.substring(uri.lastIndexOf("/"));
        //System.out.println(path);

        if(path.equals("/insertProd.pd")) {
            ProductDTO dto = new ProductDTO();
            String name = req.getParameter("name");
            double price = Double.parseDouble(req.getParameter("price"));
            String content = req.getParameter("content");
            dto.setName(name);
            dto.setPrice(price);
            dto.setContent(content);

            dao.setInsertProd(dto);

            res.sendRedirect("prodList.pd");
        } else if(path.equals("/insertPage.pd")) {
            res.sendRedirect("insertProd.jsp");
        } else if(path.equals("/prodList.pd")) {
            List<ProductDTO> list = new ArrayList<>();
            list = dao.getList();

            HttpSession session = req.getSession();
            session.setAttribute("list", list);
            res.sendRedirect("prodList.jsp");
        } else if(path.equals("/getProd.pd")) {
            ProductDTO dto = new ProductDTO();
            ProductDTO pd = new ProductDTO();
            int id = Integer.parseInt(req.getParameter("id"));
            dto.setId(id);
            pd = dao.getProd(dto);

            HttpSession session = req.getSession();
            session.setAttribute("dto", pd);
            res.sendRedirect("getProd.jsp");
        } else if(path.equals("/updateProd.pd")) {
            ProductDTO dto = new ProductDTO();
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            double price = Double.parseDouble(req.getParameter("price"));
            String content = req.getParameter("content");
            dto.setId(id);
            dto.setName(name);
            dto.setPrice(price);
            dto.setContent(content);

            dao.update(dto);
            res.sendRedirect("getProd.pd?id=" + id);
        } else if(path.equals("/delete.pd")) {
            ProductDTO dto = new ProductDTO();
            int id = Integer.parseInt(req.getParameter("id"));
            dto.setId(id);
            dao.delete(dto);
            res.sendRedirect("prodList.pd");
        }





    }


    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        doGet(req, res);
    }

}
