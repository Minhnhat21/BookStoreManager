<%@page import="bo.giohangbo"%>
<%@page import="bean.giohangbean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Giỏ hàng</title>
</head>
<body>
	 <%
   String masach=request.getParameter("ms");
   String tensach=request.getParameter("ts");
   String anh = request.getParameter("anh");
   String mscanxoa = request.getParameter("xoams");
   //String xoatatca = request.getParameter("xoaall");
	long gia = 0; 
	
   if(request.getParameter("gia") != null) {   
   	gia=Long.parseLong(request.getParameter("gia"));
   }
   // Khởi tạo giỏ hàng
   giohangbo gh;
   if(session.getAttribute("gio")==null){
	   gh = new giohangbo();
	   session.setAttribute("gio", gh);
   }
   //b1: gan session vao bien
   gh=(giohangbo)session.getAttribute("gio");
   //b2: Thao tac tren bien
   
   if(request.getParameter("xoams") != null) {
	   gh.Xoa1MatHang(mscanxoa);
   } 
   else if(request.getParameter("xoaAll") != null) {
	   gh.XoaTatCa();
   }
   else if(request.getParameter("themgio") != null){
	   gh.Them(masach, tensach, anh,gia ,(long)1 );
   } else if(request.getParameter("masach_cs") != null) {
	   String masachCS = request.getParameter("masach_cs");
	   String soluong = request.getParameter("cssl");
	   boolean isNotEmpty = soluong != null && soluong.trim().length() > 0;
	   if(isNotEmpty && !soluong.equalsIgnoreCase("0")) {   
		   gh.ChinhSuaSoLuong(masachCS, Long.parseLong(soluong));
	   } else {
		   gh.Xoa1MatHang(masachCS);
	   }
   }
   //b3: Luu bien vao session
   session.setAttribute("gio", gh);
   session.setAttribute("slsp", gh.ds.size());
   if(gh.ds.size() == 0) {
	   response.sendRedirect("hien-thi-sach.jsp");
   } else {   
   	response.sendRedirect("htgio.jsp");
   }
   %>

</body>
</html>