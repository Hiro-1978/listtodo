
<%@page import="model.Note" %>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>List To Do</h1><br>
<%
	ArrayList<Note> list = (ArrayList<Note>)request.getAttribute("list");
	for(Note note: list){
		out.println("<li>"+ note.getDetail()+ "</li>");
	}
%>
<form action>
	<input type="text" name="detail">
	<input type="submit">
</form>

</body>
</html>