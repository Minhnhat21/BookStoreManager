<%@page import="bean.khachhangbean"%>
<%@page import="bean.lichsubean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bo.lichsubo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lịch sử mua hàng</title>
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
	      <li class="active"><a href="DanhSachSach">Home</a></li>
	      <%if(session.getAttribute("slsp") == null ) {
	    	  %>
	      <li><a href="xulygiohang">Giỏ hàng (0)</a></li>
	      <% } else { %>
	      <li><a href="xulygiohang">Giỏ hàng (<%=session.getAttribute("slsp")%>)</a></li>
	      <%} %>
	      <li><a href="#">Thanh toán</a></li>
	      <li><a href="#">Lịch sử mua hàng</a></li>
	    </ul>
	    <ul class="nav navbar-nav navbar-right">
	      <%
	      	   if(session.getAttribute("dangnhap") == null) {
	      %>
	      	<li><a href="dang-ky.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
		     <li><a href="#login-modal" data-toggle="modal" ><span class="glyphicon glyphicon-log-in"></span> Đăng Nhập</a></li>
	
	    	<%
	    		}
	    		else {
	    	%>
	    	<% khachhangbean kh = (khachhangbean) session.getAttribute("dangnhap"); %>
		    	<li><a href="KiemTraDangNhap"><span class="glyphicon glyphicon-user"></span> Xin chào: <%=kh.getHoten()%></a></li>
		    	<li><a href="/WEB-INF/views/logout.jsp"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
	    	<%
	    		}
	    	%>
	 
	    </ul>
	  </div>
	</nav>
      
       <%
     
       ArrayList<lichsubean> dsLichSuMua = (ArrayList<lichsubean>) request.getAttribute("lichsumua"); 
   
       
       Boolean tontaids = dsLichSuMua.size() > 0;
       if(tontaids){ %>
    	

<div style="width: 1000px; margin-left: auto; margin-right: auto;">

<table class="table table-bordered">
  <thead style="text-align: center; background-color: #E97777">
    <tr >
      <th scope="col">Tên sách</th>
      <th scope="col">Số lượng đã mua</th>
      <th scope="col">Giá</th>
      <th scope="col">Thành tiền</th>
      <th scope="col">Ngày Mua</th>
       <th scope="col">Trạng thái</th>
    </tr>
  </thead>
  <tbody style="text-align: center; background-color: #FCDDB0">
    <% int index = 1;
    	   for(lichsubean h: dsLichSuMua){
    	   	index++;
    	   %>
       		<tr> 
 
       		<td>
       		  <span style="font-size: 18px"><%=h.getTensach() %> </span> 
       		 
       		</td>
       		<td>
       		<span><%=h.getSoLuongMua()%></span>
       		</td>
       		<td>    			
       		<span style="font-weight: bold"><%=h.getGia() %> VNĐ </span>	
       		</td>
       		<td>
       		<span style="font-weight: bold;"> <%=h.getThanhtien() %> VNĐ </span>
       		</td>
       		
       		<td>
       		<span > <%=h.getNgayMua() %></span>
       		</td>
       		<%
       		String trangThai = "";
       		if(h.isDamua()) trangThai = "Đã mua";
       		else trangThai = "Đang giao";
       		%>
       		<td>
       		<span style="font-weight: bold;"> <%=trangThai%></span>
       		</td>
       		
       		</tr>
    	   
    	   <% } 
    	   }%>
  
  </tbody>
</table>
</div>



</body>
</html>