<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LOGIN</title>
    <link rel="stylesheet" href="css/login.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
        integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">

</head>

<body>

<%
	    Cookie[] cookies=request.getCookies();
	    String user = "", password = "",rememberVal="";
	    if (cookies != null) {
	         for (Cookie cookie : cookies) {
	           if(cookie.getName().equals("cookuser")) {
	             user = cookie.getValue();
	           }
	           if(cookie.getName().equals("cookpass")){
	             password = cookie.getValue();
	           }
	           if(cookie.getName().equals("cookrem")){
	             rememberVal = cookie.getValue();
	           }
	        }
	    }
	%>
    <section>
        <!--Bắt Đầu Phần Hình Ảnh-->
        <div class="img-bg">
            <img src="image/funix.jpeg"
                alt="Hình Ảnh Minh Họa">
        </div>
        
        
        <!--Kết Thúc Phần Hình Ảnh-->
        <!--Bắt Đầu Phần Nội Dung-->
        <p>${sessionScope.error}</p>
        <div class="noi-dung">
            <div class="form">
            
                <h2>Trang Đăng Nhập</h2>
                <form action="${pageContext.request.contextPath}/login" method="post"> <!-- name="myform" onsubmit="return validation()" --> 
                    <div class="input-form">
                        <span>Tên Người Dùng</span>
                        <input type="text" name="username" autocomplete="off" value="<%=user%>" required="required" oninvalid="this.setCustomValidity('email phải có @..!!')" oninput="this.setCustomValidity('')">
                    </div>
                    <div class="input-form">
                        <span>Mật Khẩu</span>
                        <input type="password" name="password" autocomplete="off" value="<%=password%>" required="required"  oninvalid="this.setCustomValidity('PASSWORD CANNOT BE EMPTY..!!')" oninput="this.setCustomValidity('')">
                    </div>
                    <div class="nho-dang-nhap">
                        <label><input type="checkbox" name="remember" value="1"
                         <%= "1".equals(rememberVal.trim()) ? "checked=\"checked\"" : "" %>> Nhớ Đăng Nhập</label> </div>
                    <div class="input-form">
                        <input type="submit" value="Đăng Nhập">
                    </div>
                    <div class="input-form">
                        <p>Bạn Chưa Có Tài Khoản? <a href="#">Đăng Ký</a></p>
                    </div>
                </form>
                <h3>Đăng Nhập Bằng Mạng Xã Hội</h3>
                <ul class="icon-dang-nhap">
                    <li><i class="fa fa-facebook" aria-hidden="true"></i></li>
                    <li><i class="fa fa-google" aria-hidden="true"></i></li>
                    <li><i class="fa fa-twitter" aria-hidden="true"></i></li>
                </ul>
            </div>
        </div>
        <!--Kết Thúc Phần Nội Dung-->
    </section>
    <!--  <script>
      function validation() {
        var x = document.forms["myform"]["username"].value;
        var y = document.forms["myform"]["password"].value;
        if (x == null || x == "") {
          alert("USERNAME CANNOT BE EMPTY..!!");
          return false;
        }
        else if (y == null || y == "") {
            alert("PASSWORD CANNOT BE EMPTY..!!");
            return false;
          }
      }
    </script>  -->
</body>
</html>
<%
request.getSession().removeAttribute("error");
%>

