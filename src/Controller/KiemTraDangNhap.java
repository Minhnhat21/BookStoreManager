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

import bean.khachhangbean;
import bean.loaibean;
import bean.sachbean;
import bean.userbean;
import bo.khachhangbo;
import bo.loaibo;
import bo.sachbo;
import bo.userbo;

/**
 * Servlet implementation class KiemTraDangNhap
 */
@WebServlet("/KiemTraDangNhap")
public class KiemTraDangNhap extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KiemTraDangNhap() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String un=request.getParameter("userLogin");
		 String pass=request.getParameter("passwordLogin");
		 Boolean error = true;
		 if(un!=null&&pass!=null) {
			 khachhangbo khbo= new khachhangbo();
		     khachhangbean kh= khbo.ktdn(un, pass);
		     if(kh!=null) {
				 HttpSession session=request.getSession();
				 session.setAttribute("dangnhap", kh);
				 response.sendRedirect("DanhSachSach");
		     }else {
		    	 
		    	 request.setAttribute("ketquaDN", error);
		    	 RequestDispatcher rd = request.getRequestDispatcher("DanhSachSach");
				 rd.forward(request, response);
		     }
		     
		 }else {
			 request.setAttribute("ketquaDN", error);
			 RequestDispatcher rd = request.getRequestDispatcher("DanhSachSach");
			 rd.forward(request, response);
		 }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
