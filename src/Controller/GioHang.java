package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import bean.loaibean;
import bean.sachbean;
import bo.giohangbo;
import bo.loaibo;
import bo.sachbo;

/**
 * Servlet implementation class GioHang
 */
@WebServlet("/GioHang")
public class GioHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GioHang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get parameter of search-btn
		HttpSession session = request.getSession();
		
				String masach = request.getParameter("ml");
		     	String key = request.getParameter("txttk");
				
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
		        
		        
		        RequestDispatcher rp2 = request.getRequestDispatcher("/WEB-INF/views/htgio.jsp");
		        rp2.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
