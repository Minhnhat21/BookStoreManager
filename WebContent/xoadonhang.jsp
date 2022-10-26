<%@page import="bo.giohangbo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
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