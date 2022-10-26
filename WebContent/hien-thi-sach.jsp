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
	      <li class="active"><a href="DanhSachSach">Home</a></li>
	      <%if(session.getAttribute("slsp") == null ) {
	    	  %>
	      <li><a href="gio-hang.jsp">Giỏ hàng (0)</a></li>
	      <% } else { %>
	      <li><a href="gio-hang.jsp">Giỏ hàng (<%=session.getAttribute("slsp")%>)</a></li>
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
		    	<li><a href="dang-nhap.jsp"><span class="glyphicon glyphicon-user"></span> Xin chào: <%=session.getAttribute("dangnhap")%></a></li>
		    	<li><a href="logout.jsp"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
	    	<%
	    		}
	    	%>
	 
	    </ul>
	  </div>
	</nav>
	
	<!-- Thông báo đăng nhập -->
	<%
	Boolean DNThanhCong = false;
	if(session.getAttribute("ketquaDN") != null) {
		DNThanhCong = (Boolean) session.getAttribute("ketquaDN");
		if(!DNThanhCong) {%>
		  <div id="alert_error_login" class="alert alert-danger alert-dismissible">
		    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
		    <strong>Có lỗi!</strong> Đăng nhập không thành công, vui lòng <a href="#login-modal" data-toggle="modal" > đăng nhập</a> lại
		  </div>
		  <%}
		}%>
	<!-- ********************** -->
	<table width="1400" align="center">
  <tr>
  <td width="240" valign="top"> 
     <table border = "1"> <h4 padding-left: 10px>Các loại sách</h4> <hr>
     <%
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
  <td width="800" valign="top">
    <table class="table">
     <%
      /*  String masach = request.getParameter("ml");
     	String key = request.getParameter("search-book");
     	sachbo sbo = new sachbo();
       ArrayList<sachbean> dssach = sbo.getSach();
       
       if(masach != null) dssach = sbo.searcMa(masach);
       else 
    	   if(key != null) dssach = sbo.searh(key); */
       
       ArrayList<sachbean> dssach = new ArrayList<>();
       if(request.getAttribute("dsSach") != null) {
    	   dssach = (ArrayList<sachbean>) request.getAttribute("dsSach");
       }
       if(request.getAttribute("ketquatk") != null) {
    	   dssach = (ArrayList<sachbean>) request.getAttribute("ketquatk");
       }
       
    	int nsach = dssach.size();
       	for(int i = 0; i < nsach ; i += 3){
       		sachbean sach = dssach.get(i);
     %>
	        <tr>
	        <%
	        	for(int j = i; j < i + 3; j++) {
	        		if(j < nsach) {
	        			sach = dssach.get(j);
	        %>
	        	<td width="300">
		             <div class="description-book">
			            <img src="images/<%=sach.getAnh()%>" width="200"> <br>
				        <a href="xulygiohang?ms=<%=sach.getMasach()%>&ts=<%=sach.getTensach()%>&gia=<%=sach.getGia()%>&anh=<%=sach.getAnh()%>&themgio=1"><img src="images/buynow.jpg"></a>  <br>
				       <a><%=sach.getTensach() %></a>  <br>
				       Giá bán:  <%=sach.getGia() %> VNĐ <br> 
			       </div>
	        	</td>
	        	
	        	<%
	        		}
	        	}%>
	        	
	        </tr>
	      	<%
       	} %>
    </table>
   
   </td>
  <td width="200" valign="top">
  
  <form action="DanhSachSach" method="get">
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
<!--  Login form -->
<div id="login-modal" class="modal fade">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <form action="KiemTraDangNhap" method="post">
                <div class="modal-header">
                    <h4 class="modal-title">Đăng nhập</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">      
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
				 <div class="modal-footer">
                    <input class="btn btn-primary" type="submit" id="register-btn" class="btn" value="Đăng nhập">
                </div>
            </form>
        </div>
    </div>
</div>
<script type="text/javascript">
setTimeout(() => {
	  const box = document.getElementById('alert_error_login');

	  // 👇️ removes element from DOM
	  box.style.display = 'none';

	  // 👇️ hides element (still takes up space on page)
	  // box.style.visibility = 'hidden';
	}, 3000); // 👈️ time in milliseconds

</script>
</body>
</html>