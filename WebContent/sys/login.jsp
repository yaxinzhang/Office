<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>首页</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="<%=request.getContextPath()%>/js/jquery.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
</head>
<style>
li {
	list-style: none;
}

.nav-inline {
	width: 1200px;
	height: 45px;
	margin: 0 auto;
	line-height: 45px;
}

.nav-inline li {
	font-size: 13px;
	font-family: "微软雅黑";
	float: left;
	margin-left: 40px;
	margin-top: 180px;
}

.nav-inline .active {
	margin-left: 300px;
	font-weight: bold;
}

.nav-inline li a {
	colar: #2A6496;
}

.text-center-height-big {
	margin-top: 180px;
	margin-left: 470px;
}
</style>
<body>
	<div class="container">
		<h1>任务管理</h1>

			<div class="row">
				<div class="col-md-12 center">
					<div class="input-group input-group-lg">
						<span class="input-group-addon">账号：</span> <input type="text"
							id="username" name="username" class="form-control" placeholder="请输入...">
					</div>
				</div>
			</div>
			<br />
			<div class="row">
				<div class="col-md-12 center">
					<div class="input-group input-group-lg">
						<span class="input-group-addon">密码：</span> <input type="password"
							id="password" name="password" class="form-control" placeholder="请输入...">
					</div>
				</div>
			</div>
			<br />
			<div class="row">
				<div class="col-md-12">
					<button type="submit" class="btn btn-lg btn-primary btn-block" onclick="submit();">登陆</button>
					<br />
					<button type="reset"
						class="btn btn-lg btn-primary btn-block btn-warning">重置</button>
					<br /> <a href="/user/register"
						class="btn btn-default btn-lg btn-block active" role="button">注册</a>
				</div>
			</div>
		
	</div>

	<div class="container-layout">
		<div class="border-top padding-top">
			<div class="text-center">
				<ul class="nav-inline">
					<li class="active"><a href="#">网站首页</a></li>
					<li><a href="#">新闻资讯</a></li>
					<li><a href="#">产品中心</a></li>
					<li><a href="#">技术反馈</a></li>
					<li><a href="#">留言反馈</a></li>
					<li><a href="#">联系方式</a></li>
				</ul>
			</div>
			<div class="text-center-height-big">版权所有 Pintuer.com All Rights
				Reserved，图ICP备：380959609</div>
		</div>
	</div>
<script>
function submit(){
	var username = $("#username").val();
	var password = $("#password").val();
	if(username.length>0 && password.length>0){
		$.ajax({
		      url:'/user/login',
		      data:{
		        "username":username,
		        "password":password
		      },
		      type:'post',
		      cache:false,
		      dataType:'json',
		      success:function(data){
		        if(data.retno == 0)
		        {
		        	window.location.href='home';
		        }
		        else{
		        	alert(data.msg);
		        }
		      },
		      error:function(data){
			    if(data.retno == 100){
			    	window.location.href='login';
			    	alert("密码错误");
			    }
		      }
		    });
	}else{
		alert("请完整输入用户名和密码");
	}
}
</script>
</body>
<c:if test="${not empty msg}">
		${msg}
	</c:if>
</html>