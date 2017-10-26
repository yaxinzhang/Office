$(document).ready(function(){
	//这里写代码
	var url = "ws://127.0.0.1/ltSocket";
	var ws;
	if("WebSocket" in window) {
		console.log("支持");
		ws = new WebSocket(url);
	}else {
		console.log("不支持");
	}
	//websocket 发生错误时调用
	ws.onerror = function(evt) {
		console.log(evt);
	}
	
	ws.onopen = function(evt) {
		console.log("连接成功");
		console.log(evt);
	}
	
	ws.onmessage = function(evt) {
		sendMessage(evt.data);
	}
	
	ws.onclose = function(evt) {
		console.log("退出聊天室");
		sendMessage(evt.data);
	}
});
function sendNewMessage(msg) {
	var msg = $("#message").val();
	if(msg){
		$("#content").append(msg+'<br/>');
	}else{
		alert("内容为空");
	}
}
//定义一个方法用来给id 是content的 div添加信息

function sendMessage(name) {
	var msg = $("#message").val();
	if(msg){
		$("#content").append(name+"："+msg+'<br/>');
	}else{
		alert("内容为空");
	}
}