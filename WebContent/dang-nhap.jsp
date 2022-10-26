<%@page import="bo.sachbo"%>
<%@page import="dao.sachdao"%>
<%@page import="bean.sachbean"%>
<%@page import="bean.loaibean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bo.loaibo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Book Store</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/fontawesome.min.css">
  <link rel="stylesheet" href="resource/book-store-style.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script src="https://kit.fontawesome.com/20ef11b5bd.js" crossorigin="anonymous"></script>
</head>
<body>
		<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <ul class="nav navbar-nav">
	      <li class="active"><a href="#">Home</a></li>
	      <li><a href="#">Thư viện</a></li>
	      <li><a href="#">Giỏ hàng</a></li>
	      <li><a href="#">Thanh toán</a></li>
	    </ul>
	    <ul class="nav navbar-nav navbar-right">
	      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
	      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
	    </ul>
	  </div>
	</nav>
	
	<table width="1400" align="center">
  <tr>
  <td width="240" valign="top"> 
     <table border = "1"> <h4 padding-left: 10px>Các loại sách</h4> <hr>
     <%
     	loaibo lbo=new loaibo();
            ArrayList<loaibean> dsloai= lbo.getLoai();
            for(loaibean l: dsloai){
     %>
        <tr><td class="navigation-bar" width="240">
          <a  href="hien-thi-sach.jsp?ml=<%=l.getMaLoai()%>"><i class="fa-solid fa-book"></i> <%=l.getTenLoai()%></a>
        </td></tr>
        <%} %>
    </table>
  </td>
  <td width="800" valign="top">
    
   <form action="ktdn.jsp">
   <div class="form-row">
	   <div class="form-group col-md-8">
	    <label for="usernameInput">Tài khoản</label>
	    <input type="text" class="form-control" id="usernameInput" name="username" placeholder="Nhập tài khoản của bạn">
	  </div>
   </div>
   <div class="form-row">
  <div class="form-group col-md-8">
    <label for="InputPassword">Mật khẩu</label>
    <input type="password" class="form-control" id="InputPassword" name="password" placeholder="mật khẩu">
  </div>
   </div>
    <div class="form-row">
  <button type="submit" class="btn btn-primary">Đăng nhập</button>
  </div>
   </form>
   
   <%
   if(session.getAttribute("fail-login") != null) {
	   out.println(session.getAttribute("fail-login"));
   }
   %>
   
   </td>
  <td width="200" valign="top">
  
  <form action="hien-thi-sach.jsp">
  <div class="form-group">
    <label for="search-input">Tìm sách</label>
   <input id="search-input" type="text" class="form-control"  name ="search-book" >
    <small id="searchHelp" class="form-text text-muted">Tìm những cuốn sách bạn cần</small>
  </div>
  <button type="submit" class="btn btn-primary">Tìm kiếm</button>
	</form>
  </td>
  </tr>
</table>

</body>
</html>