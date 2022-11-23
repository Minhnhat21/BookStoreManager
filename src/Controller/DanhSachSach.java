package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.loaibean;
import bean.sachbean;
import bo.loaibo;
import bo.sachbo;

/**
 * Servlet implementation class DanhSachSach
 */
@WebServlet("/DanhSachSach")
public class DanhSachSach extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhSachSach() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get parameter of search-btn
		String masach = request.getParameter("ml");
     	String key = request.getParameter("search-book");
		
		loaibo lbo=new loaibo();
        ArrayList<loaibean> dsloai= lbo.getLoai();
        
        sachbo sbo = new sachbo();
        ArrayList<sachbean> dssach = sbo.getSach();
        
        if(masach != null) dssach = sbo.searcMa(masach);
        else 
     	   if(key != null) dssach = sbo.searh(key);
        
        request.setAttribute("ketquatk", dssach);
        request.setAttribute("dsLoai", dsloai);
        request.setAttribute("dsSach", dssach);
      
        RequestDispatcher rp = request.getRequestDispatcher("/WEB-INF/views/hien-thi-sach.jsp");
        rp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
