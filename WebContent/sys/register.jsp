<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body>

<form action="/user/register" method="post">
	<div>
		<label>账户：</label>
		<input type="text" name="username" >
	</div>
	<div>
		<label>密码：</label>
		<input type="password" name="password" >
	</div>
	<div>
		<button type="submit">立即注册</button>
	</div>
</form>

</body>
</html>