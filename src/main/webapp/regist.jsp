<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录页面</title>
<script type="text/javascript" src="./JQUERY/jquery-3.2.1.js"></script>
<script type="text/javascript" >
	$(function(){
		$("#username").blur( function(){	
				if (check($("#username").val(), $("#d1"))){
					<!--异步处理机制,异步javaScript和xml-->
					<!--$.ajax((js对象)) -->
					$.ajax({
						url : "servlet/validate",
						type : "POST",
						dataType : "json", //回传的数据格式
						data : {
							username : $("#username").val()
						},
						//异步请求成功
						success : function(data) {
							if (data.result == 1) {
								var $msg = $("#d1");
								$msg.text("用户名以存在！");
								$msg.css("color", "red");
								$msg.css("font-size", "8px");
							}
						},
						error : function() {
							alert("error");
						}

					});
				}
			});
		$("#password").blur( function(){	
				check($("#password").val(), $("#d2"));
			});
		$("#psw2").blur( function(){	
			var $msg = $("#d3");

			if ($("#psw2").val() != $("#password").val()) {
				$msg.text("前后密码不匹配！");
				$msg.css("color", "red");
			} else {
				$msg.text("");
			}
			});
	});
	
	function check(param , x){
		var $msg = x;
		
		if(param.length < 8){
			$msg.text("长度需要大于8位！");
			$msg.css("color", "red");
			$msg.css("font-size", "8px");
			return false;
		}else{
			$msg.text("");
			return true;
		}
			}
</script>
</head>
<body>
	<form method="post" style="text-align:center">
			<input size="40px" type="text" size="30px" id="username" name="username"placeholder="请输入用户名"  /><br/>
			<div id="d1" ></div><br/>
			<input size="40px"type="password" size="30px" id="password" placeholder="请输入密码" /><br/>
			<div id="d2"></div><br/>
			 <input size="40px"type="password"id="psw2" placeholder="请确认密码"/><br/>
			 <div id="d3"></div><br/>
			<input type="submit" size="2px" onclick="login()"  value="登录" />
		</form>
</body>
</html>