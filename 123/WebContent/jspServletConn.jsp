<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.sun.javafx.collections.MappingChange.Map" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
input[type=text] {
    width: 380px;
    height: 30px;
    box-sizing: border-box;
    border: 2px solid #ccc;
    
    font-size: 16px;

}
.sans {
    font-family:sans-serif;
    
}
.button {
    background-color: #4CAF50;
    border: none;
    color: white;
    padding: 6px 10px;
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
<script type="text/javascript">window.onload=toBottom;
function toBottom()
{
window.scrollTo(0, document.body.scrollHeight);
}</script>
<center>
<div class="sans">
<c:forEach items="${map}" var="entry"><br>
You: ${entry.key}<br>Bot: ${entry.value}<br>

</c:forEach></div>
<div>
<form action="LoginController" name="search" >
<br>
<input type="text" name="msg"/><br><br>
<input type="submit" value="Search" class="button button1">
</form></div></center>



</body>
</html>