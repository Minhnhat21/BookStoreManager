<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
/* 	session.removeAttribute("dangnhap");
	session.removeAttribute("fail-login"); */
	String tk = request.getParameter("userLogin");
	String mk = request.getParameter("passwordLogin");
	if(tk.equals("minhnhat") && mk.equals("12345"))  {
		session.setAttribute("dangnhap", "Minh Nhật");
		response.sendRedirect("hien-thi-sach.jsp");
	}
	else {		
		response.sendRedirect("hien-thi-sach.jsp?kq=1");
	}
%>
</body>
</html>