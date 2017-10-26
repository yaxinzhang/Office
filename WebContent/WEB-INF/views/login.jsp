<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>

<form action="/user/login" method="post">
	<div>
		<label>账户：</label>
		<input type="text" name="username" >
	</div>
	<div>
		<label>密码：</label>
		<input type="password" name="password" >
	</div>
	<div>
		<button type="submit">立即登录</button>
	</div>
</form>

</body>
</html>