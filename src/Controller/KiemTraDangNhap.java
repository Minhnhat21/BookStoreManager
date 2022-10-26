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
import bo.loaibo;
import bo.sachbo;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tk = request.getParameter("userLogin");
		String mk = request.getParameter("passwordLogin");
		Boolean isSuccess = false;
		HttpSession session = request.getSession();
		if(tk.equals("minhnhat") && mk.equals("12345"))  {
			session.setAttribute("dangnhap", "Minh Nhật");
			isSuccess = true;
		}	
		
		// Hien thi sach
		//get parameter of search-btn
		/*
		 * String masach = request.getParameter("ml"); String key =
		 * request.getParameter("search-book");
		 * 
		 * loaibo lbo=new loaibo(); ArrayList<loaibean> dsloai= lbo.getLoai();
		 * 
		 * sachbo sbo = new sachbo(); ArrayList<sachbean> dssach = sbo.getSach();
		 * 
		 * if(masach != null) dssach = sbo.searcMa(masach); else if(key != null) dssach
		 * = sbo.searh(key);
		 * 
		 * request.setAttribute("ketquatk", dssach); request.setAttribute("dsLoai",
		 * dsloai); request.setAttribute("dsSach", dssach);
		 */
				/*------------------------------------*/
		
		session.setAttribute("ketquaDN", isSuccess);

		RequestDispatcher rp = request.getRequestDispatcher("DanhSachSach");
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
