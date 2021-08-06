<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
var ws=new WebSocket("ws://localhost:8088/websocket")
ws.onmessage=onMessage;

function onMessage(msg){
	var data=msg.data;
	//alert(data);
	/*
	if(data=="1"){
		//div 빨강색 박스를 만들고 화면에 나타나는 작업
		document.getElementById("notice").style.visibility="visible";
		document.getElementById("notice").innerHTML=data;
		
	}else{
		//div 빨강색 박스를 사라지는 작업
		document.getElementById("notice").style.visibility="hidden";
	}
	*/
	document.getElementById("notice").style.visibility="visible";
	document.getElementById("notice").innerHTML=data;
}

function command(){
	var cmd=document.getElementById("command").value;
	ws.send(cmd)
}
</script>
websocket1.jsp
<button onclick="ws.send('hello test')">message send</button><br>
<input type="text" name="command" id="command">
<button onclick="command()">command</button><br>

<div id="notice" style="border:1px solid green;
background-color:yellow;
position:absolute;
width:200px;height:200px;
left:200px;top:200px;
visibility:hidden">
</div>
</body>
</html>