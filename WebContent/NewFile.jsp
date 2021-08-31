<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.sql.Timestamp" %>

<% Locale locale = request.getLocale();
	Calendar calendar=Calendar.getInstance(locale);
	Date dateNow = new Date(calendar.getInstance().getTimeInMillis()); /*可以拿到yyyy-mm-dd的日期格式*/
	
	Timestamp timeNow_before = new Timestamp(dateNow.getTime()); //拿到2021-08-18 05:23:53.621 包含毫秒的格式
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String strDateTime = dateFormat.format(timeNow_before); //拿到字串的格式-> 2021-08-18 05:23:53
	//要將String轉成Timestamp -> Timestamp.valueOf(strDateTime);
	//才可存到mysql DB
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
	<h4>java.sql.Date: <%= dateNow %></h4>
	<h4>java.sql.Timestamp: <%= timeNow_before %></h4>
	<h4>字串格式: <%= strDateTime %></h4>
	<h4>Timestamp格式: <%= Timestamp.valueOf(strDateTime) %></h4>
</body>
</html>