<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ page import="com.dt.wechatptf.services.MailServiceImpl"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Send Mail</title>
</head>
<body>

<%
	MailServiceImpl msi = new MailServiceImpl();
	out.println(msi.sendMail("mlr", "909103970@qq.com"));
%>

</body>
</html>