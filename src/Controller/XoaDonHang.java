package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.giohangbo;

/**
 * Servlet implementation class XoaDonHang
 */
@WebServlet("/XoaDonHang")
public class XoaDonHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaDonHang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		giohangbo gh=(giohangbo)session.getAttribute("gio");
		
		List<String> listParameterName = new ArrayList<>();
		String parameterName = "";
		for(Enumeration e = request.getParameterNames();
				e.hasMoreElements(); ){
			parameterName = (String)e.nextElement();
			listParameterName.add(parameterName);
		}
		for(String s : listParameterName) {
			if(!request.getParameter(s).equals("1")) {
				gh.Xoa1MatHang(s);	
			}
		}
		listParameterName.clear();
		session.setAttribute("gio", gh);
		session.setAttribute("slsp", gh.ds.size());
		if(gh.ds.size() == 0) {
			   response.sendRedirect("./DanhSachSach");
		 } else {   
		   	response.sendRedirect("./GioHang");
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
