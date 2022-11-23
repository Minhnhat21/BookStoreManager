<%@page import="bean.khachhangbean"%>
<%@page import="bean.giohangbean"%>
<%@page import="bo.giohangbo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.loaibean"%>
<%@page import="bo.loaibo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>Giỏ hàng</title>
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
      <li class="active"><a href="DanhSachSach">Home</a></li>
      
      <%if(session.getAttribute("slsp") == null ) {
	    	  %>
	      <li><a href="GioHang">Giỏ hàng (0)</a></li>
	      <% } else { %>
	      <li><a href="GioHang">Giỏ hàng (<%=session.getAttribute("slsp")%>)</a></li>
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
<table width="1400" align="center">
  <tr>
  <td width="200" valign="top"> 
     <table border = "1"> <h4 padding-left: 10px>Các loại sách</h4> <hr>
     <%
         boolean ghDangTrong = true;
	     ArrayList<loaibean> dsloai = new ArrayList<>();
			if(request.getAttribute("dsLoai") != null) {     			
	  		dsloai =  (ArrayList<loaibean>) request.getAttribute("dsLoai");
			}
	     for(loaibean l: dsloai){
     %>
        <tr><td class="navigation-bar" width="240">
          <a  href="DanhSachSach?ml=<%=l.getMaLoai()%>"><i class="fa-solid fa-book"></i> <%=l.getTenLoai()%></a>
        </td></tr>
        <%} %>
    </table>
  </td>
  <td width="900" valign="top">
  <form action="./XoaDonHang">
  
     <table class="table table-hover">
       <%
       String key = request.getParameter("txttk");
       giohangbo gh= (giohangbo)session.getAttribute("gio"); 
      	
       ArrayList<giohangbean> dsDonHang = gh.ds;
       
       if(key != null) {
    	   dsDonHang = gh.timkiem(key);   	   
       }
       
       ghDangTrong = dsDonHang.size() > 0;
       if(ghDangTrong){ 
    	%>
    	<tr>
    	   	<th></th>
    	   	<th></th>
    	   	<th> Tên sách</th>
    	   	<th> Số lượng</th>
    	   	<th> Thành tiền</th>
    	   	<th></th>
    	</tr>
    	 <% int index = 1;
    	   for(giohangbean h: dsDonHang){
    	   	index++;
    	   %>
       		<tr>
       		<td>
       		<div class="form-check" style="font-size: 40px; text-align: center; vertical-align: center;">
			  <input style="width: 15px; height: 15px;" class="form-check-input" type="checkbox" value="" name="<%=h.getMasach()%>">
			</div>
       		</td>
       		<td>
       		<img class="zoom-img" src="<%=h.getAnh()%>" width="50"> <br>
       		</td>
       		<%-- <td>
       		   <%=h.getMasach() %>
       		</td> --%>
       		<td>
       		  <span style="font-size: 18px"><%=h.getTensach() %> </span> 
       		   <br>
       	
       		   <span style="font-weight: bold">Đơn Giá: <%=h.getGia() %> VNĐ </span>
       		   
       		</td>
       		<td>    			
       			<input type="number" style="width: 40px;" name="<%=h.getMasach()%>" value="<%=h.getSoluong() %>" min="0" onchange="myFunction(this.name, this.value)">
       				
       		</td>
       		<td>
       		<span style="font-weight: bold; color: red"> <%=h.getThanhtien() %> VNĐ </span>
       		</td>
       		<td>
       		<a id="delete_btn" href="xulygiohang?xoams=<%=h.getMasach()%>"><i style="font-size: 20px" class="fa-regular fa-trash-can"></i></a>
       		</td>
       		</tr>
    	   
    	   <% } 
    	   }%>
    	   
       <%-- <%}  
       else {%>
    	<h4>Giỏ hàng đang trống, hãy <a href="hien-thi-sach.jsp" >quay lại</a> mua hàng</h4> 
    	<% } %> --%>
    </table>
    <input class="btn btn-danger" type="submit" value="Xóa các đơn hàng này">
  </form>
    
    <% if(ghDangTrong) {%>
    <h3>Tổng tiền: <span style="color: red" ><%=gh.TongTien()%> VNĐ</span>  </h3>
    <a class="btn btn-info" href="DanhSachSach" role="button"><i class="fa-solid fa-cart-shopping"></i> Tiếp tục mua hàng</a>
    <a href="xulygiohang?xoaAll=1" id="deleteAllBtn" class="btn btn-danger"><i class="fa-solid fa-trash"></i> Trả lại tất cả đơn</a>
    <a class="btn btn-success" href="#" role="button"><i class="fa-solid fa-cart-shopping"></i> Thanh toán</a>
    <form action="datmuaController"  method="get">
    <button type="submit" class="btn btn-primary">Đặt mua</button>
    </form>
    <%} %>
    
   </td>
  <td width="200" valign="top">
   <!-- <form action="htsach.jsp" method="get">
      <input class="form-control" name="txttk" type="text" value="" placeholder="Nhap tt"> <br>
      <input class="btn-primary" name="butdn" type="submit" value="Search">
   	</form>	  -->
   <!--Form Tìm kiếm -->
    <form action="htgio.jsp" method="get">
	  <div class="form-group">
	    <label for="search-input">Tìm sách</label>
	   <input type="text" class="form-control"  name ="txttk" placeholder="Nhập thông tin">
	    <small id="searchHelp" class="form-text text-muted">Tìm những cuốn sách trong giỏ</small>
	  </div>
	  <button type="submit" class="btn btn-primary">Tìm kiếm</button>
	</form>
    </td>
  </tr>
</table>

<!--  Login form -->
<div id="login-modal" class="modal fade">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
        <!-- form login -->
            <form action="./KiemTraDangNhap">
                <div class="modal-header">
                    <h4 class="modal-title">Đăng nhập</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">      
				<div >
                    <div class="form-row">
                        <div class="form-group col-md-12">
                        	<label>Tài khoản</label>
                            <input type="text" class="form-control" name="userLogin" placeholder="Nhập tài khoản">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-12">
                        <label>Mật khẩu</label>
                          <input type="password" class="form-control" name="passwordLogin" placeholder="Nhập mật khẩu">
                        </div>
                    </div>
                  
				</div>
                </div>
                <div class="modal-footer">
                    <input class="btn btn-primary" type="submit" id="register-btn" class="btn" value="Đăng nhập">
                </div>
            </form>
     
        </div>
    </div>
</div>
<script type="text/javascript">
function myFunction(val1, val2) {
	window.location.href = "http://localhost:8080/BookStoreManager/xulygiohang?masach_cs=" + val1 + "&cssl=" + val2;
}
</script>
</body>

</html>