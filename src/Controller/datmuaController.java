package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.giohangbean;
import bean.khachhangbean;
import bo.chitiethoadonbo;
import bo.giohangbo;
import bo.hoadonbo;

/**
 * Servlet implementation class datmuaController
 */
@WebServlet("/datmuaController")
public class datmuaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public datmuaController() {
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
			giohangbo gh=(giohangbo)session.getAttribute("gio");
			hoadonbo hdbo= new hoadonbo();
			chitiethoadonbo ctbo= new chitiethoadonbo();
			hdbo.Them(kh.getMakh());
			long maxhd=hdbo.getMaHD();
			for(giohangbean g: gh.ds) {
				//System.out.println(g.getMasach() +"  abc");
				ctbo.Them(g.getMasach().trim(), g.getSoluong(),maxhd);
			}
		}
		response.sendRedirect("lichsuController");
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
