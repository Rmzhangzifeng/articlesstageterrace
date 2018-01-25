<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>征文运营后台登陆中心</title>

<link rel="stylesheet" href="loginFileFolder/css/font-awesome.min.css"/>
<link rel="stylesheet" href="loginFileFolder/css/loginMy.css"/>

<style>
html,body{width:100%;}
</style>

</head>
<body>

<div class="main">

	<div class="center">
		<form  id="login-form">
			<i class="fa fa-user Cone">  | </i>
			<input type="text" name="userqq" id="user" placeholder="用户名"onblur="checkUser()"/>
			<span id="user_pass"></span>
			<br/>
			<i class="fa fa-key Cone">  | </i>
			<input type="password" name="userpass" id="pwd" placeholder="密码"onblur="checkUser1()"/>
			<span id="pwd_pass"></span>
			<br/>
			<span id="loginCheckFlagmsg"></span>
			<br/>
			<input type="button" value="登陆" id="login-submit-button" onclick="loginUserCheck()">
			<br/>
		</form>
	</div>
	
</div>
<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="loginFileFolder/js/loginMy.js"></script>
</body>
</html>