<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register Page</title>
</head>
<body>

	<script type="text/javascript" src="jquery.js">
    </script>
    <script type="text/javascript">
    function confirm(){
       var account=document.getElementById("account").value;
       var password = document.getElementById("password").value;
       var mail=document.getElementById("mail").value;
       $.ajax({
          	type:"POST",
            url:"http://localhost:8080/wechatpft/services/mail/register",
            data:"account="+account+"&password="+password+"&mail="+mail
       }).done(function(msg){
            alert("");
       });
    }
    </script>
        
    <center>
		<form action="register">
			Name:<input type="text" name="account" id="account" /><br /><br />
			Password:<input type="text" name="password" id="password" /><br /><br />
			Email:<input type="text" name="email" id="email" /><br /><br />
			<input type="submit" />
		</form>
	</center>

</body>
</html>