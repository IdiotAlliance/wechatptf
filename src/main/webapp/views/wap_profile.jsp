<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>会员注册</title>
	<meta name="viewport" content="width=device-width, initial-scale=1"> 
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.1.0/jquery.mobile-1.1.0.min.css" />
	<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.1.0/jquery.mobile-1.1.0.min.js"></script>
	
	<style>
		.headerbtn{
			width:50px;
			height:39px
		}
	</style>
</head>
<body>

<div data-role="page">
	<div data-role="header" data-theme="a">
		<h1 data-role="ui-title" role="heading" arial-level="1">清秋梧桐</h1>
		<a href="/wechatptf/wap/${cid}/${wxid}/index" data-role="button" data-icon="home" 
		data-corners="true" data-shadow="true" data-iconshadow="true" data-wrapperels="span" 
		data-theme="c" class="ui-btn ui-btn-left ui-shadow ui-btn-corner-all ui-btn-icon-left ui-btn-up-c">
			<span class="ui-btn-inner ui-btn-corner-all">
				<span class="ui-btn-text">首页</span>
				<span class="ui-icon ui-icon-home ui-icon-shadow">&nbsp;</span>
			</span>
		</a>
		<a onclick="submit()" data-role="button" data-icon="check" data-corners="true" 
		data-shadow="true" data-iconshadow="true" data-wrapperels="span" data-theme="c" 
		class="ui-btn ui-btn-right ui-shadow ui-btn-corner-all ui-btn-icon-left ui-btn-up-c">
			<span class="ui-btn-inner ui-btn-corner-all">
				<span class="ui-btn-text">完成</span>
				<span class="ui-icon ui-icon-check ui-icon-shadow">&nbsp;</span>
			</span>
		</a>
	</div>
</div>

</body>
</html>