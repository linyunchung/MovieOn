<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.sql.Timestamp" %>

<% Locale locale = request.getLocale();
	Calendar calendar=Calendar.getInstance(locale);
	Date dateNow = new Date(calendar.getInstance().getTimeInMillis()); /*�i�H����yyyy-mm-dd������榡*/
	
	Timestamp timeNow_before = new Timestamp(dateNow.getTime()); //����2021-08-18 05:23:53.621 �]�t�@���榡
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String strDateTime = dateFormat.format(timeNow_before); //����r�ꪺ�榡-> 2021-08-18 05:23:53
	//�n�NString�নTimestamp -> Timestamp.valueOf(strDateTime);
	//�~�i�s��mysql DB
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
	<h4>�r��榡: <%= strDateTime %></h4>
	<h4>Timestamp�榡: <%= Timestamp.valueOf(strDateTime) %></h4>
</body>
</html>