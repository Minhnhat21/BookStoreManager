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

import bean.giohangbean;
import bean.khachhangbean;
import bean.lichsubean;
import bean.sachbean;
import bo.chitiethoadonbo;
import bo.giohangbo;
import bo.hoadonbo;
import bo.lichsubo;
import bo.sachbo;

/**
 * Servlet implementation class lichsuController
 */
@WebServlet("/lichsuController")
public class lichsuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lichsuController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		khachhangbean kh= (khachhangbean)session.getAttribute("dangnhap");
		if(kh==null)
			response.sendRedirect("KiemTraDangNhap");
		else {
			lichsubo lsbo = new lichsubo();
	        ArrayList<lichsubean> dsls = lsbo.getLichSu(kh.getMakh());
	       
	        request.setAttribute("lichsumua", dsls);

	        RequestDispatcher rp = request.getRequestDispatcher("/WEB-INF/views/lichsumuahang.jsp");
	        rp.forward(request, response);
		}
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
