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
	
	<div class="content-primary">
	<form>
		<ul data-role="listview" data-inset="true" class="ui-listview ui-listview-inset ui-corner-all ui-shadow">
			<li data-role="fieldcontain" class="ui-field-contain ui-body ui-br ui-li ui-li-static ui-body-c ui-corner-top">
	        	<label for="name" class="ui-input-text">昵称：</label>
	        	<input type="text" name="name" id="name" value="" class="ui-input-text ui-body-c ui-corner-all ui-shadow-inset">
			</li>
			<li data-role="fieldcontain" class="ui-field-contain ui-body ui-br ui-li ui-li-static ui-body-c">
				<fieldset data-role="controlgroup" class="ui-corner-all ui-controlgroup ui-controlgroup-vertical">
					<div role="heading" class="ui-controlgroup-label">性别：</div>
					<div class="ui-controlgroup-controls">
						<div class="ui-radio">
							<input type="radio" name="gender" id="male" value=0 checked="checked">
							<label for="male" data-corners="true" data-shadow="false" data-iconshadow="true" data-wrapperels="span" data-icon="radio-off" data-theme="c" class="ui-btn ui-btn-icon-left ui-corner-top ui-btn-up-c ui-radio-on">
								<span class="ui-btn-inner ui-corner-top">
									<span class="ui-btn-text">男</span>
									<span class="ui-icon ui-icon-shadow ui-icon-radio-on">&nbsp;</span>
								</span>
							</label>
						</div>
			         	<div class="ui-radio">
			         		<input type="radio" name="gender" id="female" value=1>
			         		<label for="female" data-corners="true" data-shadow="false" data-iconshadow="true" data-wrapperels="span" data-icon="radio-off" data-theme="c" class="ui-btn ui-btn-icon-left ui-radio-off ui-corner-bottom ui-controlgroup-last ui-btn-up-c">
			         			<span class="ui-btn-inner ui-corner-bottom ui-controlgroup-last">
			         				<span class="ui-btn-text">女</span>
			         				<span class="ui-icon ui-icon-radio-off ui-icon-shadow">&nbsp;</span>
			         			</span>
			         		</label>
			         	</div>
			        </div>
				</fieldset>
			</li>
			<li data-role="fieldcontain" class="ui-field-contain ui-body ui-br ui-li ui-li-static ui-body-c ui-corner-top">
	        	<label for="birthday" class="ui-input-text">出生日期：</label>
	        	<input type="text" name="birthday" id="birthday" value="" class="ui-input-text ui-body-c ui-corner-all ui-shadow-inset">
			</li>
			<li data-role="fieldcontain" class="ui-field-contain ui-body ui-br ui-li ui-li-static ui-body-c">
	        	<label for="address" class="ui-input-text">地址：</label>
				<textarea cols="40" rows="8" name="address" id="address" class="ui-input-text ui-body-c ui-corner-all ui-shadow-inset"></textarea>
			</li>
			<li data-role="fieldcontain" class="ui-field-contain ui-body ui-br ui-li ui-li-static ui-body-c ui-corner-top">
	        	<label for="mail" class="ui-input-text">邮箱：</label>
	        	<input type="text" name="mail" id="mail" value="" class="ui-input-text ui-body-c ui-corner-all ui-shadow-inset">
			</li>
			<li data-role="fieldcontain" class="ui-field-contain ui-body ui-br ui-li ui-li-static ui-body-c ui-corner-top">
	        	<label for="phone" class="ui-input-text">电话：</label>
	        	<input type="text" name="phone" id="phone" value="" class="ui-input-text ui-body-c ui-corner-all ui-shadow-inset">
			</li>
		</ul>
	</form>
	</div>
	
</div>

</body>
</html>