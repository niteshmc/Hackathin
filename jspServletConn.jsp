<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.sun.javafx.collections.MappingChange.Map"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
body {
    background-image: url("http://www.technobuffalo.com/wp-content/uploads/2012/04/Verizon-Wireless.jpeg");
    background-color: #cccccc;
    width: 100%;
}
input[type=text] {
	width: 380px;
	height: 30px;
	box-sizing: border-box;
	border: 2px solid #ccc;
	border-collapse: collapse;
	font-size: 16px;
}

.sans {
	font-family: sans-serif;
	width: 380px;
	
	height: 400px;
	overflow: hidden;
	background-color:white;
}

.button {
	background-color: #4CAF50;
	border: none;
	color: white;
	padding: 10px 20px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}

.button1 {
	background-color: #c0392b;
	color: white;
}
</style>

</head>
<body>
	<script type="text/javascript">
		window.onload = toBottom;

		function toBottom() {
			var elem= document.getElementById("chat");
			elem.scrollTop =  elem.scrollHeight;
		}
	</script>
	<center><br>
	<img src="http://campaign.verizon.com/HBONOW/img/verizon-logo-white.png"/>
	<br><br>
		<div class="sans" id="chat">
			<br>Hi! How can I help you?<br> <br>
			<c:forEach items="${map}" var="entry">
				<table cellpadding="10" style="border: 1px solid white;">
					<tr>
						<td width="50%"></td>
						<td align="right" style="color: white; background-color: #7f8c8d;">
							${entry.key}
					</tr>
					<tr>
						<td align="left" style="color: black; background-color: #ecf0f1;">${entry.value}</td>
					</tr>
				</table>
			</c:forEach>
		</div>
		<div>
			<form action="LoginController" name="search" method="post">
				<br> <input type="text" name="msg" /><br> <br> <input
					type="submit" value="Ask!" class="button button1">
			</form>
		</div>
	</center>
</body>
</html>